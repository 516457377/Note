# Android 日常笔记(五)

1. 还在用Eclipse的我偶尔下载一个项目需要打开一下as，然后更新个sdk。再移到Eclipse里面，如果更新了sdk.buildtools 就会可能出现
    ```Failed to load E:\SDK\android-sdk-windows\build-tools\27.0.2\lib\dx.jar```
    这样的问题，解决办法有两个。  
    - 在项目文件的`project.properties`加上`sdk.buildtools=25.0.2 //设置sdk使用的buildtools版本`就可以了。后面的值根据之前能用的修改。  
    - 第二个办法就是，直接替换sdk里面`27.0.2\lib\dx.jar`把这个替换成之前能用的`dx.jar`这样比较方便的就是不用每个项目都改一次；可能存在缺陷，具体未知。
    
                            if (currentList.checkedCams.size() == 0) {
                            Toast.makeText(MainActivity.this,getResources().getString(R.string.select_at_one_item), Toast.LENGTH_LONG).show();
                        } else {
                            hideControlPanelAndGrid();
                            GridData[] arr = new GridData[4];
                            int size = currentList.checkedCams.size();
                            int dif = 4 - currentList.checkedCams.size();
                            int level = 0;
                            if (size >= 4)
                                level = 4;
                            else level = size;
                            for (int u = 0; u < level; u++)
                                arr[u] = currentList.checkedCams.get(u);
                            if (size < 4)
                                for (int k = size; k < 4; ++k)
                                    arr[k] = null;
                            start2X2camerasMode(arr);
                        }
