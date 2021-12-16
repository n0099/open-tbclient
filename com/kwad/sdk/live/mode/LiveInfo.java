package com.kwad.sdk.live.mode;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes3.dex */
public class LiveInfo extends com.kwad.sdk.core.response.kwai.a implements Serializable {
    public static /* synthetic */ Interceptable $ic = null;
    public static final long serialVersionUID = -6382708726460249425L;
    public transient /* synthetic */ FieldHolder $fh;
    public int audienceCount;
    public String caption;
    public String coverUrl;
    public CoverUrlCdn coverUrlCdn;
    public List<CoverThumbnailUrl> cover_thumbnail_urls;
    public String exp_tag;
    public String linkCode;
    public String liveStreamId;
    public List<LiveStreamPlayCDNNode> liveStreamPlayCdnList;
    public String livingLink;
    public String nebulaKwaiLink;
    public transient String pcursor;
    public String playInfo;
    public String shennongjiaLog;
    public String title;
    public User user;

    /* loaded from: classes3.dex */
    public static class CoverThumbnailUrl extends com.kwad.sdk.core.response.kwai.a implements Serializable {
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

    /* loaded from: classes3.dex */
    public static class CoverUrlCdn extends com.kwad.sdk.core.response.kwai.a implements Serializable {
        public static /* synthetic */ Interceptable $ic = null;
        public static final long serialVersionUID = 6749700043335441902L;
        public transient /* synthetic */ FieldHolder $fh;
        public String coverUrlCdn;

        public CoverUrlCdn() {
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

    /* loaded from: classes3.dex */
    public static class LiveStreamPlayCDNNode extends com.kwad.sdk.core.response.kwai.a implements Serializable {
        public static /* synthetic */ Interceptable $ic = null;
        public static final long serialVersionUID = 4809830877910908561L;
        public transient /* synthetic */ FieldHolder $fh;
        public String cdn;
        public String url;

        public LiveStreamPlayCDNNode() {
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

    /* loaded from: classes3.dex */
    public static class User extends com.kwad.sdk.core.response.kwai.a implements Serializable {
        public static /* synthetic */ Interceptable $ic = null;
        public static final long serialVersionUID = 8394855164198099170L;
        public transient /* synthetic */ FieldHolder $fh;
        public List<HeadUrl> headurls;
        public long user_id;
        public String user_name;

        /* loaded from: classes3.dex */
        public static class HeadUrl extends com.kwad.sdk.core.response.kwai.a implements Serializable {
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
        this.coverUrlCdn = new CoverUrlCdn();
        this.cover_thumbnail_urls = new ArrayList();
        this.liveStreamPlayCdnList = new ArrayList();
    }
}
