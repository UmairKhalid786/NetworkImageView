# NetworkImageView

NetworkImageView is a simple but a very useful way of writing and using image views in Android for handling network images using glide library.

Will be available as a library soon. 



## Usage

```xml
<com.techlad.niv.NetworkImageView
    android:scaleType="center"
    android:layout_width="match_parent"
    android:layout_height="200dp"
    app:cacheEnable="true"
    app:networkUrl="@string/url_string"
    app:defaultImage="@drawable/ic_launcher_background"
    />
```

you can specify url and cache bool in xml 
```xml
app:cacheEnable="true"
app:networkUrl="@string/url_string"
```
Or 
You can specify them in JAVA
```java
NetworkImageView imageView = findViewById(R.id.network_img);
//No need write 10 to 20 lines of code to load network image
imageView.loadFromURL("https://dummyimage.com/600x400/000/fff&text=Network+Image");
//Cache image for next time
imageView.setEnableCache(true);
```
### References ###
 * Glide library [https://github.com/bumptech/glide]

## Contributing
Pull requests are welcome. For major changes, please open an issue first to discuss what you would like to change.

Please make sure to update tests as appropriate.

## License
[MIT](https://choosealicense.com/licenses/mit/)