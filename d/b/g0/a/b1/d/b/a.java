package d.b.g0.a.b1.d.b;

import android.app.Activity;
import android.content.Context;
import android.content.res.Resources;
import android.media.MediaMetadataRetriever;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AnimationUtils;
import android.widget.BaseAdapter;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import com.baidu.searchbox.common.runtime.AppRuntime;
import com.baidu.swan.apps.media.chooser.model.ImageModel;
import com.baidu.swan.apps.media.chooser.model.MediaModel;
import com.baidu.swan.apps.media.chooser.model.VideoModel;
import com.baidu.webkit.sdk.PermissionRequest;
import com.facebook.drawee.backends.pipeline.Fresco;
import com.facebook.drawee.view.SimpleDraweeView;
import com.facebook.imagepipeline.common.ImageDecodeOptions;
import com.facebook.imagepipeline.common.ResizeOptions;
import com.facebook.imagepipeline.request.ImageRequestBuilder;
import com.sina.weibo.sdk.utils.FileUtils;
import d.b.g0.a.i2.f0;
import d.b.g0.a.i2.h0;
import java.io.File;
import java.util.ArrayList;
import java.util.Locale;
/* loaded from: classes2.dex */
public class a extends BaseAdapter {

    /* renamed from: e  reason: collision with root package name */
    public Activity f43385e;

    /* renamed from: f  reason: collision with root package name */
    public ArrayList<MediaModel> f43386f = new ArrayList<>();

    /* renamed from: g  reason: collision with root package name */
    public d.b.g0.a.b1.d.d.e f43387g;

    /* renamed from: h  reason: collision with root package name */
    public int f43388h;
    public int i;
    public FrameLayout.LayoutParams j;

    /* renamed from: d.b.g0.a.b1.d.b.a$a  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public class View$OnClickListenerC0606a implements View.OnClickListener {
        public View$OnClickListenerC0606a() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            a.this.m();
        }
    }

    /* loaded from: classes2.dex */
    public class b implements View.OnClickListener {
        public b() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            a.this.k();
        }
    }

    /* loaded from: classes2.dex */
    public class c implements d.b.g0.a.k1.b {
        public c() {
        }

        @Override // d.b.g0.a.k1.b
        public void a(String str) {
            a.this.u();
        }

        @Override // d.b.g0.a.k1.b
        public void b(int i, String str) {
        }
    }

    /* loaded from: classes2.dex */
    public class d implements d.b.g0.a.b1.d.d.b {
        public d() {
        }

        @Override // d.b.g0.a.b1.d.d.b
        public void a(File file) {
            ImageModel imageModel = new ImageModel(file.getAbsolutePath());
            imageModel.g(file.length());
            d.b.g0.a.b1.d.c.e.i(imageModel);
            Bundle bundle = new Bundle();
            bundle.putBoolean("compressed", d.b.g0.a.b1.d.c.d.f43434e);
            bundle.putString("swanAppId", d.b.g0.a.b1.d.c.d.f43435f);
            bundle.putParcelableArrayList("mediaModels", d.b.g0.a.b1.d.c.e.e());
            bundle.putString("swanTmpPath", d.b.g0.a.b1.d.c.d.j);
            d.b.g0.a.b1.d.c.d.g(a.this.f43385e, bundle);
        }

        @Override // d.b.g0.a.b1.d.d.b
        public void b(String str) {
        }
    }

    /* loaded from: classes2.dex */
    public class e implements d.b.g0.a.k1.b {
        public e() {
        }

        @Override // d.b.g0.a.k1.b
        public void a(String str) {
            a.this.t();
        }

        @Override // d.b.g0.a.k1.b
        public void b(int i, String str) {
        }
    }

    /* loaded from: classes2.dex */
    public class f implements d.b.g0.a.b1.d.d.b {
        public f() {
        }

        @Override // d.b.g0.a.b1.d.d.b
        public void a(File file) {
            d.b.g0.a.b1.d.c.e.i(d.b.g0.a.b1.d.c.b.c(file));
            Bundle bundle = new Bundle();
            bundle.putBoolean("compressed", d.b.g0.a.b1.d.c.d.f43434e);
            bundle.putString("swanAppId", d.b.g0.a.b1.d.c.d.f43435f);
            bundle.putParcelableArrayList("mediaModels", d.b.g0.a.b1.d.c.e.e());
            bundle.putString("swanTmpPath", d.b.g0.a.b1.d.c.d.j);
            d.b.g0.a.b1.d.c.d.g(a.this.f43385e, bundle);
        }

        @Override // d.b.g0.a.b1.d.d.b
        public void b(String str) {
        }
    }

    /* loaded from: classes2.dex */
    public class g implements View.OnClickListener {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ MediaModel f43395e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ j f43396f;

        public g(MediaModel mediaModel, j jVar) {
            this.f43395e = mediaModel;
            this.f43396f = jVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            a.this.l(this.f43395e, this.f43396f);
        }
    }

    /* loaded from: classes2.dex */
    public class h implements View.OnClickListener {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ MediaModel f43398e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ int f43399f;

        public h(MediaModel mediaModel, int i) {
            this.f43398e = mediaModel;
            this.f43399f = i;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            a.this.j(this.f43398e, this.f43399f);
        }
    }

    /* loaded from: classes2.dex */
    public class i implements View.OnClickListener {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ VideoModel f43401e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ MediaModel f43402f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ int f43403g;

        public i(VideoModel videoModel, MediaModel mediaModel, int i) {
            this.f43401e = videoModel;
            this.f43402f = mediaModel;
            this.f43403g = i;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (a.this.s(this.f43401e.b()) && !a.this.n(this.f43401e.j())) {
                a.this.j(this.f43402f, this.f43403g);
            }
        }
    }

    /* loaded from: classes2.dex */
    public class j {

        /* renamed from: a  reason: collision with root package name */
        public SimpleDraweeView f43405a;

        /* renamed from: b  reason: collision with root package name */
        public ImageView f43406b;

        /* renamed from: c  reason: collision with root package name */
        public TextView f43407c;

        /* renamed from: d  reason: collision with root package name */
        public ImageView f43408d;

        /* renamed from: e  reason: collision with root package name */
        public View f43409e;

        /* renamed from: f  reason: collision with root package name */
        public View f43410f;

        /* renamed from: g  reason: collision with root package name */
        public TextView f43411g;

        /* renamed from: h  reason: collision with root package name */
        public View f43412h;

        public j(a aVar, View view) {
            this.f43405a = (SimpleDraweeView) view.findViewById(d.b.g0.a.f.album_item_img);
            this.f43408d = (ImageView) view.findViewById(d.b.g0.a.f.album_item_select_checkbox);
            this.f43407c = (TextView) view.findViewById(d.b.g0.a.f.album_item_select_number);
            this.f43410f = view.findViewById(d.b.g0.a.f.album_item_selected_check);
            this.f43409e = view.findViewById(d.b.g0.a.f.album_item_select_circle_view);
            this.f43406b = (ImageView) view.findViewById(d.b.g0.a.f.album_item_unable_shadow);
            this.f43412h = view.findViewById(d.b.g0.a.f.album_item_tip_bg);
            this.f43411g = (TextView) view.findViewById(d.b.g0.a.f.album_item_right_bottom_tip);
        }
    }

    public a(Activity activity) {
        this.f43385e = activity;
        int m = h0.m(this.f43385e);
        int l = h0.l(this.f43385e);
        this.f43388h = m / 4;
        this.i = l / 4;
        this.j = new FrameLayout.LayoutParams((m - h0.e(this.f43385e, 10.0f)) / 4, (m - h0.e(this.f43385e, 10.0f)) / 4);
    }

    public final void A(j jVar, View view) {
        Resources resources = this.f43385e.getResources();
        view.setBackgroundColor(resources.getColor(d.b.g0.a.c.aiapps_white));
        jVar.f43405a.setBackgroundColor(resources.getColor(d.b.g0.a.c.swanapp_album_item_select_bg));
        jVar.f43407c.setTextColor(resources.getColor(d.b.g0.a.c.swanapp_album_select_number_color));
        jVar.f43412h.setBackground(resources.getDrawable(d.b.g0.a.e.swanapp_album_item_duration_bg));
        jVar.f43411g.setTextColor(resources.getColor(d.b.g0.a.c.aiapps_white));
        jVar.f43406b.setBackgroundColor(resources.getColor(d.b.g0.a.c.swanapp_album_unenable_shadow_color));
        jVar.f43405a.setLayoutParams(this.j);
        jVar.f43406b.setLayoutParams(this.j);
        jVar.f43406b.setVisibility(8);
        jVar.f43407c.setVisibility(8);
        jVar.f43410f.setVisibility(8);
        jVar.f43412h.setVisibility(8);
        jVar.f43410f.setVisibility(0);
        jVar.f43408d.setImageResource(d.b.g0.a.e.swanapp_album_unselect_thumb_icon);
        jVar.f43412h.setVisibility(0);
        FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) jVar.f43412h.getLayoutParams();
        layoutParams.width = this.f43385e.getResources().getDimensionPixelSize(d.b.g0.a.d.swanapp_album_item_tip_width);
        layoutParams.height = this.f43385e.getResources().getDimensionPixelSize(d.b.g0.a.d.swanapp_album_item_time_height);
        jVar.f43412h.setLayoutParams(layoutParams);
    }

    @Override // android.widget.Adapter
    public int getCount() {
        return d.b.g0.a.b1.d.c.d.f43437h ? this.f43386f.size() + 1 : this.f43386f.size();
    }

    @Override // android.widget.Adapter
    public Object getItem(int i2) {
        if (d.b.g0.a.b1.d.c.d.f43437h) {
            if (i2 == 0) {
                return null;
            }
            return this.f43386f.get(i2 - 1);
        }
        return this.f43386f.get(i2);
    }

    @Override // android.widget.Adapter
    public long getItemId(int i2) {
        return i2;
    }

    @Override // android.widget.BaseAdapter, android.widget.Adapter
    public int getItemViewType(int i2) {
        return (d.b.g0.a.b1.d.c.d.f43437h && i2 == 0) ? 0 : 1;
    }

    @Override // android.widget.Adapter
    public View getView(int i2, View view, ViewGroup viewGroup) {
        j jVar;
        if (getItemViewType(i2) == 0) {
            View inflate = LayoutInflater.from(this.f43385e).inflate(d.b.g0.a.g.swanapp_album_camera_item, (ViewGroup) null, false);
            r(inflate);
            return inflate;
        }
        if (view == null) {
            view = LayoutInflater.from(this.f43385e).inflate(d.b.g0.a.g.swanapp_album_select_item, (ViewGroup) null);
            jVar = new j(this, view);
            view.setTag(jVar);
        } else {
            jVar = (j) view.getTag();
        }
        A(jVar, view);
        MediaModel mediaModel = (MediaModel) getItem(i2);
        if (mediaModel == null) {
            return view;
        }
        y(mediaModel.b(), jVar);
        v(mediaModel, jVar, i2);
        w(mediaModel, jVar, i2);
        return view;
    }

    @Override // android.widget.BaseAdapter, android.widget.Adapter
    public int getViewTypeCount() {
        return 2;
    }

    public final void j(MediaModel mediaModel, int i2) {
        if (d.b.g0.a.b1.d.c.d.f(d.b.g0.a.b1.d.c.d.f43433d, mediaModel)) {
            return;
        }
        if (d.b.g0.a.b1.d.c.d.f43437h) {
            i2--;
        }
        Bundle bundle = new Bundle();
        bundle.putBoolean("compressed", d.b.g0.a.b1.d.c.d.f43434e);
        bundle.putString("swanAppId", d.b.g0.a.b1.d.c.d.f43435f);
        bundle.putString("mode", d.b.g0.a.b1.d.c.d.f43433d);
        bundle.putString("previewFrom", "clickItem");
        bundle.putInt("previewPosition", i2);
        d.b.g0.a.b1.d.c.d.k(this.f43385e, bundle);
    }

    public final void k() {
        if (d.b.g0.a.b1.d.c.e.d() >= d.b.g0.a.b1.d.c.d.f43432c) {
            d.b.g0.a.b1.d.c.d.j(d.b.g0.a.b1.d.c.d.f43433d);
        } else if (f0.b() < 52428800) {
            d.b.g0.a.q1.b.f.d.f(AppRuntime.getAppContext(), this.f43385e.getResources().getString(d.b.g0.a.h.swanapp_album_camera_no_storage)).C();
        } else {
            p(this.f43385e);
        }
    }

    public final void l(MediaModel mediaModel, j jVar) {
        int d2 = d.b.g0.a.b1.d.c.e.d();
        if (!d.b.g0.a.b1.d.c.e.f(mediaModel)) {
            if (d2 >= d.b.g0.a.b1.d.c.d.f43432c) {
                d.b.g0.a.b1.d.c.d.j(d.b.g0.a.b1.d.c.d.f43433d);
                return;
            } else if (d2 <= 0 || !TextUtils.equals(d.b.g0.a.b1.d.c.d.f43433d, "single") || TextUtils.equals(d.b.g0.a.b1.d.c.e.b(), mediaModel.e())) {
                jVar.f43408d.setImageResource(d.b.g0.a.e.swanapp_album_select_icon_bg);
                jVar.f43407c.setVisibility(0);
                jVar.f43407c.setText(String.valueOf(d.b.g0.a.b1.d.c.e.c(mediaModel) + 1));
                d.b.g0.a.b1.d.c.e.i(mediaModel);
                jVar.f43409e.startAnimation(AnimationUtils.loadAnimation(this.f43385e, d.b.g0.a.a.swanapp_album_checkshake));
                d.b.g0.a.b1.d.d.e eVar = this.f43387g;
                if (eVar != null) {
                    eVar.a(d2);
                }
                notifyDataSetChanged();
                return;
            } else {
                d.b.g0.a.q1.b.f.d.e(this.f43385e, d.b.g0.a.h.swanapp_album_select_single).C();
                return;
            }
        }
        d.b.g0.a.b1.d.c.e.h(mediaModel);
        jVar.f43408d.setImageResource(d.b.g0.a.e.swanapp_album_unselect_thumb_icon);
        jVar.f43407c.setVisibility(8);
        d.b.g0.a.b1.d.d.e eVar2 = this.f43387g;
        if (eVar2 != null) {
            eVar2.a(d2);
        }
        notifyDataSetChanged();
    }

    public final void m() {
        if (d.b.g0.a.b1.d.c.e.d() >= d.b.g0.a.b1.d.c.d.f43432c) {
            d.b.g0.a.b1.d.c.d.j(d.b.g0.a.b1.d.c.d.f43433d);
        } else {
            q(this.f43385e);
        }
    }

    public final boolean n(long j2) {
        if (j2 < 3000) {
            d.b.g0.a.q1.b.f.d.f(AppRuntime.getAppContext(), this.f43385e.getString(d.b.g0.a.h.swanapp_album_video_duration_min)).C();
            return true;
        } else if (j2 > 300000) {
            d.b.g0.a.q1.b.f.d.f(AppRuntime.getAppContext(), this.f43385e.getString(d.b.g0.a.h.swanapp_album_video_duration_max)).C();
            return true;
        } else {
            return false;
        }
    }

    public final String o(long j2) {
        long j3 = j2 / 1000;
        long j4 = j3 / 3600;
        long j5 = j3 % 3600;
        String format = String.format(Locale.getDefault(), "%02d", Long.valueOf(j5 / 60));
        String format2 = String.format(Locale.getDefault(), "%02d", Long.valueOf(j5 % 60));
        if (j4 == 0) {
            return this.f43385e.getString(d.b.g0.a.h.swanapp_video_duration, new Object[]{format, format2});
        }
        return this.f43385e.getString(d.b.g0.a.h.swanapp_video_duration_hour, new Object[]{String.format(Locale.getDefault(), "%02d", Long.valueOf(j4)), format, format2});
    }

    public final void p(Context context) {
        d.b.g0.a.k1.a.a(PermissionRequest.RESOURCE_VIDEO_CAPTURE, new String[]{PermissionRequest.RESOURCE_VIDEO_CAPTURE}, 1, context, new e());
    }

    public final void q(Context context) {
        d.b.g0.a.k1.a.a(PermissionRequest.RESOURCE_VIDEO_CAPTURE, new String[]{PermissionRequest.RESOURCE_VIDEO_CAPTURE}, 1, context, new c());
    }

    public final void r(View view) {
        view.findViewById(d.b.g0.a.f.album_camera_enter).setLayoutParams(this.j);
        view.setTag(null);
        view.setClickable(true);
        ImageView imageView = (ImageView) view.findViewById(d.b.g0.a.f.album_camera_icon);
        if (TextUtils.equals(d.b.g0.a.b1.d.c.d.f43431b, "Image")) {
            imageView.setImageResource(d.b.g0.a.e.swanapp_album_camera_item_selector);
            view.setOnClickListener(new View$OnClickListenerC0606a());
            return;
        }
        imageView.setImageResource(d.b.g0.a.e.swanapp_album_camera_video_selector);
        view.setOnClickListener(new b());
    }

    public final boolean s(String str) {
        String str2;
        try {
            MediaMetadataRetriever mediaMetadataRetriever = new MediaMetadataRetriever();
            mediaMetadataRetriever.setDataSource(str);
            str2 = mediaMetadataRetriever.extractMetadata(12);
        } catch (Exception e2) {
            if (d.b.g0.a.b1.d.c.c.f43426a) {
                e2.printStackTrace();
            }
            str2 = "";
        }
        if (!TextUtils.isEmpty(str2) && str2.startsWith(FileUtils.VIDEO_FILE_START)) {
            return TextUtils.equals("video/mp4", str2) || TextUtils.equals("video/3gp", str2) || TextUtils.equals("video/webm", str2) || TextUtils.equals("video/mkv", str2);
        }
        d.b.g0.a.q1.b.f.d.f(AppRuntime.getAppContext(), this.f43385e.getString(d.b.g0.a.h.swanapp_album_video_format)).C();
        return false;
    }

    public final void t() {
        d.b.g0.a.b1.d.c.b.e(this.f43385e, d.b.g0.a.b1.d.c.d.f43435f, d.b.g0.a.b1.d.c.d.f43436g, d.b.g0.a.b1.d.c.d.i, new f());
    }

    public final void u() {
        d.b.g0.a.b1.d.c.b.f(this.f43385e, d.b.g0.a.b1.d.c.d.f43435f, new d());
    }

    public final void v(MediaModel mediaModel, j jVar, int i2) {
        if (d.b.g0.a.b1.d.c.e.f(mediaModel)) {
            jVar.f43408d.setImageResource(d.b.g0.a.e.swanapp_album_select_icon_bg);
            jVar.f43407c.setVisibility(0);
            jVar.f43407c.setText(String.valueOf(d.b.g0.a.b1.d.c.e.c(mediaModel) + 1));
        }
        if (d.b.g0.a.b1.d.c.d.f(d.b.g0.a.b1.d.c.d.f43433d, mediaModel)) {
            jVar.f43406b.setVisibility(0);
        } else {
            jVar.f43406b.setVisibility(8);
        }
        if (!d.b.g0.a.b1.d.c.c.f43429d) {
            jVar.f43412h.setVisibility(8);
        } else if (d.b.g0.a.b1.d.c.d.d(mediaModel.b())) {
            jVar.f43411g.setText(this.f43385e.getString(d.b.g0.a.h.swanapp_album_gif_photo));
        } else if (d.b.g0.a.b1.d.c.d.e(mediaModel.b())) {
            jVar.f43411g.setText(this.f43385e.getString(d.b.g0.a.h.swanapp_album_large_photo));
        } else {
            jVar.f43412h.setVisibility(8);
        }
        jVar.f43410f.setOnClickListener(new g(mediaModel, jVar));
        jVar.f43405a.setOnClickListener(new h(mediaModel, i2));
    }

    public final void w(MediaModel mediaModel, j jVar, int i2) {
        if (mediaModel instanceof VideoModel) {
            VideoModel videoModel = (VideoModel) mediaModel;
            jVar.f43412h.setVisibility(0);
            FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) jVar.f43412h.getLayoutParams();
            if ((videoModel.j() / 3600) / 1000 > 0) {
                layoutParams.width = this.f43385e.getResources().getDimensionPixelSize(d.b.g0.a.d.swanapp_album_item_longtime_width);
            } else {
                layoutParams.width = this.f43385e.getResources().getDimensionPixelSize(d.b.g0.a.d.swanapp_album_item_time_width);
            }
            layoutParams.height = this.f43385e.getResources().getDimensionPixelSize(d.b.g0.a.d.swanapp_album_item_time_height);
            jVar.f43412h.setLayoutParams(layoutParams);
            jVar.f43411g.setText(o(videoModel.j()));
            jVar.f43405a.setOnClickListener(new i(videoModel, mediaModel, i2));
        }
    }

    public void x(ArrayList<MediaModel> arrayList) {
        if (this.f43386f.size() > 0) {
            this.f43386f.clear();
        }
        this.f43386f.addAll(arrayList);
        d.b.g0.a.b1.d.c.d.i(this.f43386f);
        notifyDataSetChanged();
    }

    public final void y(String str, j jVar) {
        ImageRequestBuilder newBuilderWithSource = ImageRequestBuilder.newBuilderWithSource(Uri.fromFile(new File(str)));
        newBuilderWithSource.setResizeOptions(new ResizeOptions((int) (this.f43388h / 2.0f), (int) (this.i / 2.0f)));
        newBuilderWithSource.setLocalThumbnailPreviewsEnabled(true);
        newBuilderWithSource.setImageDecodeOptions(ImageDecodeOptions.newBuilder().setForceStaticImage(true).build());
        jVar.f43405a.setController(Fresco.newDraweeControllerBuilder().setImageRequest(newBuilderWithSource.build()).setAutoPlayAnimations(false).setOldController(jVar.f43405a.getController()).build());
    }

    public void z(d.b.g0.a.b1.d.d.e eVar) {
        this.f43387g = eVar;
    }
}
