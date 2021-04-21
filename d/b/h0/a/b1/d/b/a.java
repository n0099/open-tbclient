package d.b.h0.a.b1.d.b;

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
import d.b.h0.a.i2.f0;
import d.b.h0.a.i2.h0;
import java.io.File;
import java.util.ArrayList;
import java.util.Locale;
/* loaded from: classes2.dex */
public class a extends BaseAdapter {

    /* renamed from: e  reason: collision with root package name */
    public Activity f44106e;

    /* renamed from: f  reason: collision with root package name */
    public ArrayList<MediaModel> f44107f = new ArrayList<>();

    /* renamed from: g  reason: collision with root package name */
    public d.b.h0.a.b1.d.d.e f44108g;

    /* renamed from: h  reason: collision with root package name */
    public int f44109h;
    public int i;
    public FrameLayout.LayoutParams j;

    /* renamed from: d.b.h0.a.b1.d.b.a$a  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public class View$OnClickListenerC0638a implements View.OnClickListener {
        public View$OnClickListenerC0638a() {
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
    public class c implements d.b.h0.a.k1.b {
        public c() {
        }

        @Override // d.b.h0.a.k1.b
        public void a(String str) {
            a.this.u();
        }

        @Override // d.b.h0.a.k1.b
        public void b(int i, String str) {
        }
    }

    /* loaded from: classes2.dex */
    public class d implements d.b.h0.a.b1.d.d.b {
        public d() {
        }

        @Override // d.b.h0.a.b1.d.d.b
        public void a(File file) {
            ImageModel imageModel = new ImageModel(file.getAbsolutePath());
            imageModel.g(file.length());
            d.b.h0.a.b1.d.c.e.i(imageModel);
            Bundle bundle = new Bundle();
            bundle.putBoolean("compressed", d.b.h0.a.b1.d.c.d.f44155e);
            bundle.putString("swanAppId", d.b.h0.a.b1.d.c.d.f44156f);
            bundle.putParcelableArrayList("mediaModels", d.b.h0.a.b1.d.c.e.e());
            bundle.putString("swanTmpPath", d.b.h0.a.b1.d.c.d.j);
            d.b.h0.a.b1.d.c.d.g(a.this.f44106e, bundle);
        }

        @Override // d.b.h0.a.b1.d.d.b
        public void b(String str) {
        }
    }

    /* loaded from: classes2.dex */
    public class e implements d.b.h0.a.k1.b {
        public e() {
        }

        @Override // d.b.h0.a.k1.b
        public void a(String str) {
            a.this.t();
        }

        @Override // d.b.h0.a.k1.b
        public void b(int i, String str) {
        }
    }

    /* loaded from: classes2.dex */
    public class f implements d.b.h0.a.b1.d.d.b {
        public f() {
        }

        @Override // d.b.h0.a.b1.d.d.b
        public void a(File file) {
            d.b.h0.a.b1.d.c.e.i(d.b.h0.a.b1.d.c.b.c(file));
            Bundle bundle = new Bundle();
            bundle.putBoolean("compressed", d.b.h0.a.b1.d.c.d.f44155e);
            bundle.putString("swanAppId", d.b.h0.a.b1.d.c.d.f44156f);
            bundle.putParcelableArrayList("mediaModels", d.b.h0.a.b1.d.c.e.e());
            bundle.putString("swanTmpPath", d.b.h0.a.b1.d.c.d.j);
            d.b.h0.a.b1.d.c.d.g(a.this.f44106e, bundle);
        }

        @Override // d.b.h0.a.b1.d.d.b
        public void b(String str) {
        }
    }

    /* loaded from: classes2.dex */
    public class g implements View.OnClickListener {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ MediaModel f44116e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ j f44117f;

        public g(MediaModel mediaModel, j jVar) {
            this.f44116e = mediaModel;
            this.f44117f = jVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            a.this.l(this.f44116e, this.f44117f);
        }
    }

    /* loaded from: classes2.dex */
    public class h implements View.OnClickListener {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ MediaModel f44119e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ int f44120f;

        public h(MediaModel mediaModel, int i) {
            this.f44119e = mediaModel;
            this.f44120f = i;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            a.this.j(this.f44119e, this.f44120f);
        }
    }

    /* loaded from: classes2.dex */
    public class i implements View.OnClickListener {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ VideoModel f44122e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ MediaModel f44123f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ int f44124g;

        public i(VideoModel videoModel, MediaModel mediaModel, int i) {
            this.f44122e = videoModel;
            this.f44123f = mediaModel;
            this.f44124g = i;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (a.this.s(this.f44122e.b()) && !a.this.n(this.f44122e.j())) {
                a.this.j(this.f44123f, this.f44124g);
            }
        }
    }

    /* loaded from: classes2.dex */
    public class j {

        /* renamed from: a  reason: collision with root package name */
        public SimpleDraweeView f44126a;

        /* renamed from: b  reason: collision with root package name */
        public ImageView f44127b;

        /* renamed from: c  reason: collision with root package name */
        public TextView f44128c;

        /* renamed from: d  reason: collision with root package name */
        public ImageView f44129d;

        /* renamed from: e  reason: collision with root package name */
        public View f44130e;

        /* renamed from: f  reason: collision with root package name */
        public View f44131f;

        /* renamed from: g  reason: collision with root package name */
        public TextView f44132g;

        /* renamed from: h  reason: collision with root package name */
        public View f44133h;

        public j(a aVar, View view) {
            this.f44126a = (SimpleDraweeView) view.findViewById(d.b.h0.a.f.album_item_img);
            this.f44129d = (ImageView) view.findViewById(d.b.h0.a.f.album_item_select_checkbox);
            this.f44128c = (TextView) view.findViewById(d.b.h0.a.f.album_item_select_number);
            this.f44131f = view.findViewById(d.b.h0.a.f.album_item_selected_check);
            this.f44130e = view.findViewById(d.b.h0.a.f.album_item_select_circle_view);
            this.f44127b = (ImageView) view.findViewById(d.b.h0.a.f.album_item_unable_shadow);
            this.f44133h = view.findViewById(d.b.h0.a.f.album_item_tip_bg);
            this.f44132g = (TextView) view.findViewById(d.b.h0.a.f.album_item_right_bottom_tip);
        }
    }

    public a(Activity activity) {
        this.f44106e = activity;
        int m = h0.m(this.f44106e);
        int l = h0.l(this.f44106e);
        this.f44109h = m / 4;
        this.i = l / 4;
        this.j = new FrameLayout.LayoutParams((m - h0.e(this.f44106e, 10.0f)) / 4, (m - h0.e(this.f44106e, 10.0f)) / 4);
    }

    public final void A(j jVar, View view) {
        Resources resources = this.f44106e.getResources();
        view.setBackgroundColor(resources.getColor(d.b.h0.a.c.aiapps_white));
        jVar.f44126a.setBackgroundColor(resources.getColor(d.b.h0.a.c.swanapp_album_item_select_bg));
        jVar.f44128c.setTextColor(resources.getColor(d.b.h0.a.c.swanapp_album_select_number_color));
        jVar.f44133h.setBackground(resources.getDrawable(d.b.h0.a.e.swanapp_album_item_duration_bg));
        jVar.f44132g.setTextColor(resources.getColor(d.b.h0.a.c.aiapps_white));
        jVar.f44127b.setBackgroundColor(resources.getColor(d.b.h0.a.c.swanapp_album_unenable_shadow_color));
        jVar.f44126a.setLayoutParams(this.j);
        jVar.f44127b.setLayoutParams(this.j);
        jVar.f44127b.setVisibility(8);
        jVar.f44128c.setVisibility(8);
        jVar.f44131f.setVisibility(8);
        jVar.f44133h.setVisibility(8);
        jVar.f44131f.setVisibility(0);
        jVar.f44129d.setImageResource(d.b.h0.a.e.swanapp_album_unselect_thumb_icon);
        jVar.f44133h.setVisibility(0);
        FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) jVar.f44133h.getLayoutParams();
        layoutParams.width = this.f44106e.getResources().getDimensionPixelSize(d.b.h0.a.d.swanapp_album_item_tip_width);
        layoutParams.height = this.f44106e.getResources().getDimensionPixelSize(d.b.h0.a.d.swanapp_album_item_time_height);
        jVar.f44133h.setLayoutParams(layoutParams);
    }

    @Override // android.widget.Adapter
    public int getCount() {
        return d.b.h0.a.b1.d.c.d.f44158h ? this.f44107f.size() + 1 : this.f44107f.size();
    }

    @Override // android.widget.Adapter
    public Object getItem(int i2) {
        if (d.b.h0.a.b1.d.c.d.f44158h) {
            if (i2 == 0) {
                return null;
            }
            return this.f44107f.get(i2 - 1);
        }
        return this.f44107f.get(i2);
    }

    @Override // android.widget.Adapter
    public long getItemId(int i2) {
        return i2;
    }

    @Override // android.widget.BaseAdapter, android.widget.Adapter
    public int getItemViewType(int i2) {
        return (d.b.h0.a.b1.d.c.d.f44158h && i2 == 0) ? 0 : 1;
    }

    @Override // android.widget.Adapter
    public View getView(int i2, View view, ViewGroup viewGroup) {
        j jVar;
        if (getItemViewType(i2) == 0) {
            View inflate = LayoutInflater.from(this.f44106e).inflate(d.b.h0.a.g.swanapp_album_camera_item, (ViewGroup) null, false);
            r(inflate);
            return inflate;
        }
        if (view == null) {
            view = LayoutInflater.from(this.f44106e).inflate(d.b.h0.a.g.swanapp_album_select_item, (ViewGroup) null);
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
        if (d.b.h0.a.b1.d.c.d.f(d.b.h0.a.b1.d.c.d.f44154d, mediaModel)) {
            return;
        }
        if (d.b.h0.a.b1.d.c.d.f44158h) {
            i2--;
        }
        Bundle bundle = new Bundle();
        bundle.putBoolean("compressed", d.b.h0.a.b1.d.c.d.f44155e);
        bundle.putString("swanAppId", d.b.h0.a.b1.d.c.d.f44156f);
        bundle.putString("mode", d.b.h0.a.b1.d.c.d.f44154d);
        bundle.putString("previewFrom", "clickItem");
        bundle.putInt("previewPosition", i2);
        d.b.h0.a.b1.d.c.d.k(this.f44106e, bundle);
    }

    public final void k() {
        if (d.b.h0.a.b1.d.c.e.d() >= d.b.h0.a.b1.d.c.d.f44153c) {
            d.b.h0.a.b1.d.c.d.j(d.b.h0.a.b1.d.c.d.f44154d);
        } else if (f0.b() < 52428800) {
            d.b.h0.a.q1.b.f.d.f(AppRuntime.getAppContext(), this.f44106e.getResources().getString(d.b.h0.a.h.swanapp_album_camera_no_storage)).C();
        } else {
            p(this.f44106e);
        }
    }

    public final void l(MediaModel mediaModel, j jVar) {
        int d2 = d.b.h0.a.b1.d.c.e.d();
        if (!d.b.h0.a.b1.d.c.e.f(mediaModel)) {
            if (d2 >= d.b.h0.a.b1.d.c.d.f44153c) {
                d.b.h0.a.b1.d.c.d.j(d.b.h0.a.b1.d.c.d.f44154d);
                return;
            } else if (d2 <= 0 || !TextUtils.equals(d.b.h0.a.b1.d.c.d.f44154d, "single") || TextUtils.equals(d.b.h0.a.b1.d.c.e.b(), mediaModel.e())) {
                jVar.f44129d.setImageResource(d.b.h0.a.e.swanapp_album_select_icon_bg);
                jVar.f44128c.setVisibility(0);
                jVar.f44128c.setText(String.valueOf(d.b.h0.a.b1.d.c.e.c(mediaModel) + 1));
                d.b.h0.a.b1.d.c.e.i(mediaModel);
                jVar.f44130e.startAnimation(AnimationUtils.loadAnimation(this.f44106e, d.b.h0.a.a.swanapp_album_checkshake));
                d.b.h0.a.b1.d.d.e eVar = this.f44108g;
                if (eVar != null) {
                    eVar.a(d2);
                }
                notifyDataSetChanged();
                return;
            } else {
                d.b.h0.a.q1.b.f.d.e(this.f44106e, d.b.h0.a.h.swanapp_album_select_single).C();
                return;
            }
        }
        d.b.h0.a.b1.d.c.e.h(mediaModel);
        jVar.f44129d.setImageResource(d.b.h0.a.e.swanapp_album_unselect_thumb_icon);
        jVar.f44128c.setVisibility(8);
        d.b.h0.a.b1.d.d.e eVar2 = this.f44108g;
        if (eVar2 != null) {
            eVar2.a(d2);
        }
        notifyDataSetChanged();
    }

    public final void m() {
        if (d.b.h0.a.b1.d.c.e.d() >= d.b.h0.a.b1.d.c.d.f44153c) {
            d.b.h0.a.b1.d.c.d.j(d.b.h0.a.b1.d.c.d.f44154d);
        } else {
            q(this.f44106e);
        }
    }

    public final boolean n(long j2) {
        if (j2 < 3000) {
            d.b.h0.a.q1.b.f.d.f(AppRuntime.getAppContext(), this.f44106e.getString(d.b.h0.a.h.swanapp_album_video_duration_min)).C();
            return true;
        } else if (j2 > 300000) {
            d.b.h0.a.q1.b.f.d.f(AppRuntime.getAppContext(), this.f44106e.getString(d.b.h0.a.h.swanapp_album_video_duration_max)).C();
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
            return this.f44106e.getString(d.b.h0.a.h.swanapp_video_duration, new Object[]{format, format2});
        }
        return this.f44106e.getString(d.b.h0.a.h.swanapp_video_duration_hour, new Object[]{String.format(Locale.getDefault(), "%02d", Long.valueOf(j4)), format, format2});
    }

    public final void p(Context context) {
        d.b.h0.a.k1.a.a(PermissionRequest.RESOURCE_VIDEO_CAPTURE, new String[]{PermissionRequest.RESOURCE_VIDEO_CAPTURE}, 1, context, new e());
    }

    public final void q(Context context) {
        d.b.h0.a.k1.a.a(PermissionRequest.RESOURCE_VIDEO_CAPTURE, new String[]{PermissionRequest.RESOURCE_VIDEO_CAPTURE}, 1, context, new c());
    }

    public final void r(View view) {
        view.findViewById(d.b.h0.a.f.album_camera_enter).setLayoutParams(this.j);
        view.setTag(null);
        view.setClickable(true);
        ImageView imageView = (ImageView) view.findViewById(d.b.h0.a.f.album_camera_icon);
        if (TextUtils.equals(d.b.h0.a.b1.d.c.d.f44152b, "Image")) {
            imageView.setImageResource(d.b.h0.a.e.swanapp_album_camera_item_selector);
            view.setOnClickListener(new View$OnClickListenerC0638a());
            return;
        }
        imageView.setImageResource(d.b.h0.a.e.swanapp_album_camera_video_selector);
        view.setOnClickListener(new b());
    }

    public final boolean s(String str) {
        String str2;
        try {
            MediaMetadataRetriever mediaMetadataRetriever = new MediaMetadataRetriever();
            mediaMetadataRetriever.setDataSource(str);
            str2 = mediaMetadataRetriever.extractMetadata(12);
        } catch (Exception e2) {
            if (d.b.h0.a.b1.d.c.c.f44147a) {
                e2.printStackTrace();
            }
            str2 = "";
        }
        if (!TextUtils.isEmpty(str2) && str2.startsWith(FileUtils.VIDEO_FILE_START)) {
            return TextUtils.equals("video/mp4", str2) || TextUtils.equals("video/3gp", str2) || TextUtils.equals("video/webm", str2) || TextUtils.equals("video/mkv", str2);
        }
        d.b.h0.a.q1.b.f.d.f(AppRuntime.getAppContext(), this.f44106e.getString(d.b.h0.a.h.swanapp_album_video_format)).C();
        return false;
    }

    public final void t() {
        d.b.h0.a.b1.d.c.b.e(this.f44106e, d.b.h0.a.b1.d.c.d.f44156f, d.b.h0.a.b1.d.c.d.f44157g, d.b.h0.a.b1.d.c.d.i, new f());
    }

    public final void u() {
        d.b.h0.a.b1.d.c.b.f(this.f44106e, d.b.h0.a.b1.d.c.d.f44156f, new d());
    }

    public final void v(MediaModel mediaModel, j jVar, int i2) {
        if (d.b.h0.a.b1.d.c.e.f(mediaModel)) {
            jVar.f44129d.setImageResource(d.b.h0.a.e.swanapp_album_select_icon_bg);
            jVar.f44128c.setVisibility(0);
            jVar.f44128c.setText(String.valueOf(d.b.h0.a.b1.d.c.e.c(mediaModel) + 1));
        }
        if (d.b.h0.a.b1.d.c.d.f(d.b.h0.a.b1.d.c.d.f44154d, mediaModel)) {
            jVar.f44127b.setVisibility(0);
        } else {
            jVar.f44127b.setVisibility(8);
        }
        if (!d.b.h0.a.b1.d.c.c.f44150d) {
            jVar.f44133h.setVisibility(8);
        } else if (d.b.h0.a.b1.d.c.d.d(mediaModel.b())) {
            jVar.f44132g.setText(this.f44106e.getString(d.b.h0.a.h.swanapp_album_gif_photo));
        } else if (d.b.h0.a.b1.d.c.d.e(mediaModel.b())) {
            jVar.f44132g.setText(this.f44106e.getString(d.b.h0.a.h.swanapp_album_large_photo));
        } else {
            jVar.f44133h.setVisibility(8);
        }
        jVar.f44131f.setOnClickListener(new g(mediaModel, jVar));
        jVar.f44126a.setOnClickListener(new h(mediaModel, i2));
    }

    public final void w(MediaModel mediaModel, j jVar, int i2) {
        if (mediaModel instanceof VideoModel) {
            VideoModel videoModel = (VideoModel) mediaModel;
            jVar.f44133h.setVisibility(0);
            FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) jVar.f44133h.getLayoutParams();
            if ((videoModel.j() / 3600) / 1000 > 0) {
                layoutParams.width = this.f44106e.getResources().getDimensionPixelSize(d.b.h0.a.d.swanapp_album_item_longtime_width);
            } else {
                layoutParams.width = this.f44106e.getResources().getDimensionPixelSize(d.b.h0.a.d.swanapp_album_item_time_width);
            }
            layoutParams.height = this.f44106e.getResources().getDimensionPixelSize(d.b.h0.a.d.swanapp_album_item_time_height);
            jVar.f44133h.setLayoutParams(layoutParams);
            jVar.f44132g.setText(o(videoModel.j()));
            jVar.f44126a.setOnClickListener(new i(videoModel, mediaModel, i2));
        }
    }

    public void x(ArrayList<MediaModel> arrayList) {
        if (this.f44107f.size() > 0) {
            this.f44107f.clear();
        }
        this.f44107f.addAll(arrayList);
        d.b.h0.a.b1.d.c.d.i(this.f44107f);
        notifyDataSetChanged();
    }

    public final void y(String str, j jVar) {
        ImageRequestBuilder newBuilderWithSource = ImageRequestBuilder.newBuilderWithSource(Uri.fromFile(new File(str)));
        newBuilderWithSource.setResizeOptions(new ResizeOptions((int) (this.f44109h / 2.0f), (int) (this.i / 2.0f)));
        newBuilderWithSource.setLocalThumbnailPreviewsEnabled(true);
        newBuilderWithSource.setImageDecodeOptions(ImageDecodeOptions.newBuilder().setForceStaticImage(true).build());
        jVar.f44126a.setController(Fresco.newDraweeControllerBuilder().setImageRequest(newBuilderWithSource.build()).setAutoPlayAnimations(false).setOldController(jVar.f44126a.getController()).build());
    }

    public void z(d.b.h0.a.b1.d.d.e eVar) {
        this.f44108g = eVar;
    }
}
