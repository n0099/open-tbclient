package com.kwad.sdk.live.mode;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes6.dex */
public class LiveInfo extends com.kwad.sdk.core.response.a.a implements Serializable {
    public static /* synthetic */ Interceptable $ic = null;
    public static final long serialVersionUID = -6382708726460249425L;
    public transient /* synthetic */ FieldHolder $fh;
    public String audienceCount;
    public String caption;
    public List<CoverThumbnailUrl> cover_thumbnail_urls;
    public String exp_tag;
    public String liveStreamId;
    public transient String pcursor;
    public String playInfo;
    public User user;

    /* loaded from: classes6.dex */
    public static class CoverThumbnailUrl extends com.kwad.sdk.core.response.a.a implements Serializable {
        public static /* synthetic */ Interceptable $ic = null;
        public static final long serialVersionUID = -9411857293708312L;
        public transient /* synthetic */ FieldHolder $fh;
        public String cdn;
        public String url;
        public String urlPattern;

        public CoverThumbnailUrl() {
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

    /* loaded from: classes6.dex */
    public static class User extends com.kwad.sdk.core.response.a.a implements Serializable {
        public static /* synthetic */ Interceptable $ic = null;
        public static final long serialVersionUID = 8394855164198099170L;
        public transient /* synthetic */ FieldHolder $fh;
        public List<HeadUrl> headurls;
        public long user_id;
        public String user_name;

        /* loaded from: classes6.dex */
        public static class HeadUrl extends com.kwad.sdk.core.response.a.a implements Serializable {
            public static /* synthetic */ Interceptable $ic = null;
            public static final long serialVersionUID = 7710129978455547652L;
            public transient /* synthetic */ FieldHolder $fh;
            public String cdn;
            public String url;

            public HeadUrl() {
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

        public User() {
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
            this.headurls = new ArrayList();
        }
    }

    public LiveInfo() {
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
        this.user = new User();
        this.cover_thumbnail_urls = new ArrayList();
    }
}
