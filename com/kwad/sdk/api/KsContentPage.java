package com.kwad.sdk.api;

import android.view.View;
import androidx.annotation.Keep;
import androidx.annotation.MainThread;
import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import com.kwad.sdk.api.core.KsAdSdkApi;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.util.List;
@KsAdSdkApi
@Keep
/* loaded from: classes3.dex */
public interface KsContentPage {

    @KsAdSdkApi
    @Keep
    /* loaded from: classes3.dex */
    public static class ContentItem {
        public String id;
        public int materialType = 0;
        public int position;

        @KsAdSdkApi
        @Keep
        @Retention(RetentionPolicy.SOURCE)
        /* loaded from: classes3.dex */
        public @interface MaterialType {
            public static final int AD = 2;
            public static final int CONTENT = 1;
            public static final int THIRD_AD = 3;
            public static final int UNKNOWN = 0;
        }
    }

    @KsAdSdkApi
    @Keep
    /* loaded from: classes3.dex */
    public interface OnPageLoadListener {
        @KsAdSdkApi
        @Keep
        void onLoadError(KsContentPage ksContentPage);

        @KsAdSdkApi
        @Keep
        void onLoadFinish(KsContentPage ksContentPage, int i);

        @KsAdSdkApi
        @Keep
        void onLoadStart(KsContentPage ksContentPage, int i);
    }

    @KsAdSdkApi
    @Keep
    /* loaded from: classes3.dex */
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
    /* loaded from: classes3.dex */
    public static abstract class SubShowItem {
        @KsAdSdkApi
        @Keep
        public abstract int getItemViewType();

        @KsAdSdkApi
        @Keep
        public abstract View instantiateItem();

        public void onPageCreate() {
        }

        @KsAdSdkApi
        @Keep
        public void onPageDestroy() {
        }

        @KsAdSdkApi
        @Keep
        public void onPagePause() {
        }

        @KsAdSdkApi
        @Keep
        public void onPageResume() {
        }

        @KsAdSdkApi
        @Keep
        public void onPageVisibleChange(boolean z) {
        }
    }

    @KsAdSdkApi
    @Keep
    /* loaded from: classes3.dex */
    public interface VideoListener {
        @KsAdSdkApi
        @Keep
        void onVideoPlayCompleted(ContentItem contentItem);

        @KsAdSdkApi
        @Keep
        void onVideoPlayError(ContentItem contentItem, int i, int i2);

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
