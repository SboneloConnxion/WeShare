# WeShare
Trying to attach an independent listview fragment to a corresponding tab.
I have 7 classes, FinalListView activity displays the listview fragment when I run it.
RowItem class sets and gets the content for each row (from @strings/arrays) in a final listview.
ListViewAdaperActivity is an Adaper, it adapts contents for each row to a listview in fragment_send.xml.
SendActivity.java is supposed to responsible displaying something under the tab "SEND", ever since I replaced the TextView with the ListView,  it shows nothing at all.
MainActivity.java runs the app smoothly, but without the ListView.
per_list_item.xml is a structure for each row.
Anything else works fine I think.
