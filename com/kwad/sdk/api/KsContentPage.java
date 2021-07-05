package com.kwad.sdk.api;

import android.view.View;
import androidx.annotation.Keep;
import androidx.annotation.MainThread;
import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.kwad.sdk.api.core.KsAdSdkApi;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.util.List;
@KsAdSdkApi
@Keep
/* loaded from: classes7.dex */
public interface KsContentPage {

    @KsAdSdkApi
    @Keep
    /* loaded from: classes7.dex */
    public static class ContentItem {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public String id;
        public int materialType;
        public int position;

        @KsAdSdkApi
        @Keep
        @Retention(RetentionPolicy.SOURCE)
        /* loaded from: classes7.dex */
        public @interface MaterialType {
            public static final int AD = 2;
            public static final int CONTENT = 1;
            public static final int THIRD_AD = 3;
            public static final int UNKNOWN = 0;
        }

        public ContentItem() {
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
            this.materialType = 0;
        }
    }

    @KsAdSdkApi
    @Keep
    /* loaded from: classes7.dex */
    public interface OnPageLoadListener {
        @KsAdSdkApi
        @Keep
        void onLoadError(KsContentPage ksContentPage);

        @KsAdSdkApi
        @Keep
        void onLoadFinish(KsContentPage ksContentPage, int i2);

        @KsAdSdkApi
        @Keep
        void onLoadStart(KsContentPage ksContentPage, int i2);
    }

    @KsAdSdkApi
    @Keep
    /* loaded from: classes7.dex */
    public interface PageListener {
        @KsAdSdkApi
        @Keep
        @MainThread
        void onPageEnter(ContentItem contentItem);

        @KsAdSdkApi
        @Keep
        @MainThread
        void onPageLeave(ContentItem contentItem);

        @KsAdSdkApi
        @Keep
        @MainThread
        void onPagePause(ContentItem contentItem);

        @KsAdSdkApi
        @Keep
        @MainThread
        void onPageResume(ContentItem contentItem);
    }

    @KsAdSdkApi
    @Keep
    /* loaded from: classes7.dex */
    public static abstract class SubShowItem {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public SubShowItem() {
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

        @KsAdSdkApi
        @Keep
        public abstract int getItemViewType();

        @KsAdSdkApi
        @Keep
        public abstract View instantiateItem();

        public void onPageCreate() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            }
        }

        @KsAdSdkApi
        @Keep
        public void onPageDestroy() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            }
        }

        @KsAdSdkApi
        @Keep
        public void onPagePause() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            }
        }

        @KsAdSdkApi
        @Keep
        public void onPageResume() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            }
        }

        @KsAdSdkApi
        @Keep
        public void onPageVisibleChange(boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeZ(1048582, this, z) == null) {
            }
        }
    }

    @KsAdSdkApi
    @Keep
    /* loaded from: classes7.dex */
    public interface VideoListener {
        @KsAdSdkApi
        @Keep
        void onVideoPlayCompleted(ContentItem contentItem);

        @KsAdSdkApi
        @Keep
        void onVideoPlayError(ContentItem contentItem, int i2, int i3);

        @KsAdSdkApi
        @Keep
        void onVideoPlayPaused(ContentItem contentItem);

        @KsAdSdkApi
        @Keep
        void onVideoPlayResume(ContentItem contentItem);

        @KsAdSdkApi
        @Keep
        void onVideoPlayStart(ContentItem contentItem);
    }

    @KsAdSdkApi
    @Keep
    void addPageLoadListener(OnPageLoadListener onPageLoadListener);

    @KsAdSdkApi
    @Keep
    void addSubItem(List<SubShowItem> list);

    @NonNull
    @KsAdSdkApi
    @Keep
    Fragment getFragment();

    @KsAdSdkApi
    @Keep
    int getSubCountInPage();

    @KsAdSdkApi
    @Keep
    void setAddSubEnable(boolean z);

    @KsAdSdkApi
    @Keep
    void setPageListener(PageListener pageListener);

    @KsAdSdkApi
    @Keep
    void setVideoListener(VideoListener videoListener);

    void tryToRefresh();
}
