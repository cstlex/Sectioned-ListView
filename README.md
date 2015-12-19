[ ![Download](https://api.bintray.com/packages/cstlex/maven/sectionedlistadapter/images/download.svg) ](https://bintray.com/cstlex/maven/sectionedlistadapter/_latestVersion)
# Sectioned-ListAdapter

Sectioned List Adapter is simple adapter for ListView

##Installation

```
compile 'com.cstlex:sectioned-listview:0.1.0'
```

##Usage

```java
class ListAdapter extends SectionedAdapter {

    public ListAdapter(){
        super(MainActivity.this);
        registerLayoutIdentifier("first", R.layout.container_first_section);
        registerLayoutIdentifier("second", R.layout.container_second_section);
        registerLayoutIdentifier("third", R.layout.container_third_section);
    }

    @Override
    public int getNumSections(){
        return 3;
    }

    @Override
    public int getNumRows(int section){
        int rows;
        switch (section){
            case 0:
            rows = 1;
            break;
            case 1:
            rows = 2;
            break;
            case 2:
            rows = 3;
            break;
            default:
            rows = 1;
            break;
        }
        return rows;
    }

    @Override
    public Object getItem(int section, int row){
        return null;
    }

    @Override
    public String identifierForIndex(int section, int row){
        String identifier = "first";
        switch (section){
            case 0:
            identifier = "first";
            break;
            case 1:
            identifier = "second";
            break;
            case 2:
            identifier = "third";
            break;
        }
        return identifier;
    }

    @Override
    public View getView(int section, int row, View view){
        return view;
    }
}
```
registering identifiers can be done at outside since registerLayoutIdentifier() is public function

and of course one section can have more than one identifier

"View view" in getView() is never null since it will automatically inflate proper layout according to identifer that is specified in identifierForIndex()


##License
MIT License
See "LICENSE" file for detail