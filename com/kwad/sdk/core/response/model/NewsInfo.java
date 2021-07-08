package com.kwad.sdk.core.response.model;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.kwad.sdk.core.response.model.PhotoInfo;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes6.dex */
public class NewsInfo extends com.kwad.sdk.core.response.a.a implements Serializable {
    public static /* synthetic */ Interceptable $ic = null;
    public static final long serialVersionUID = 2846473099852025182L;
    public transient /* synthetic */ FieldHolder $fh;
    public PhotoInfo.AuthorInfo authorInfo;
    public String content;
    public int contentSourceType;
    public List<ImageInfo> imageInfo;
    public long photoId;
    public long publishTimestamp;
    public String templateUrl;
    public List<ImageInfo> thumbnailInfo;
    public String title;

    /* loaded from: classes6.dex */
    public static class ImageInfo extends com.kwad.sdk.core.response.a.a implements Serializable {
        public static /* synthetic */ Interceptable $ic = null;
        public static final long serialVersionUID = 4257305450674055184L;
        public transient /* synthetic */ FieldHolder $fh;
        public int height;
        public String origin;
        public String url;
        public int width;

        public ImageInfo() {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }
    }

    public NewsInfo() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.authorInfo = new PhotoInfo.AuthorInfo();
        this.imageInfo = new ArrayList();
        this.thumbnailInfo = new ArrayList();
    }
}
