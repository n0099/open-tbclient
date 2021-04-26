package d.a.h0.a.b1.d.b;

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
import d.a.h0.a.i2.f0;
import d.a.h0.a.i2.h0;
import java.io.File;
import java.util.ArrayList;
import java.util.Locale;
/* loaded from: classes3.dex */
public class a extends BaseAdapter {

    /* renamed from: e  reason: collision with root package name */
    public Activity f41380e;

    /* renamed from: f  reason: collision with root package name */
    public ArrayList<MediaModel> f41381f = new ArrayList<>();

    /* renamed from: g  reason: collision with root package name */
    public d.a.h0.a.b1.d.d.e f41382g;

    /* renamed from: h  reason: collision with root package name */
    public int f41383h;

    /* renamed from: i  reason: collision with root package name */
    public int f41384i;
    public FrameLayout.LayoutParams j;

    /* renamed from: d.a.h0.a.b1.d.b.a$a  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public class View$OnClickListenerC0577a implements View.OnClickListener {
        public View$OnClickListenerC0577a() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            a.this.m();
        }
    }

    /* loaded from: classes3.dex */
    public class b implements View.OnClickListener {
        public b() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            a.this.k();
        }
    }

    /* loaded from: classes3.dex */
    public class c implements d.a.h0.a.k1.b {
        public c() {
        }

        @Override // d.a.h0.a.k1.b
        public void a(String str) {
            a.this.u();
        }

        @Override // d.a.h0.a.k1.b
        public void b(int i2, String str) {
        }
    }

    /* loaded from: classes3.dex */
    public class d implements d.a.h0.a.b1.d.d.b {
        public d() {
        }

        @Override // d.a.h0.a.b1.d.d.b
        public void a(File file) {
            ImageModel imageModel = new ImageModel(file.getAbsolutePath());
            imageModel.g(file.length());
            d.a.h0.a.b1.d.c.e.i(imageModel);
            Bundle bundle = new Bundle();
            bundle.putBoolean("compressed", d.a.h0.a.b1.d.c.d.f41430e);
            bundle.putString("swanAppId", d.a.h0.a.b1.d.c.d.f41431f);
            bundle.putParcelableArrayList("mediaModels", d.a.h0.a.b1.d.c.e.e());
            bundle.putString("swanTmpPath", d.a.h0.a.b1.d.c.d.j);
            d.a.h0.a.b1.d.c.d.g(a.this.f41380e, bundle);
        }

        @Override // d.a.h0.a.b1.d.d.b
        public void b(String str) {
        }
    }

    /* loaded from: classes3.dex */
    public class e implements d.a.h0.a.k1.b {
        public e() {
        }

        @Override // d.a.h0.a.k1.b
        public void a(String str) {
            a.this.t();
        }

        @Override // d.a.h0.a.k1.b
        public void b(int i2, String str) {
        }
    }

    /* loaded from: classes3.dex */
    public class f implements d.a.h0.a.b1.d.d.b {
        public f() {
        }

        @Override // d.a.h0.a.b1.d.d.b
        public void a(File file) {
            d.a.h0.a.b1.d.c.e.i(d.a.h0.a.b1.d.c.b.c(file));
            Bundle bundle = new Bundle();
            bundle.putBoolean("compressed", d.a.h0.a.b1.d.c.d.f41430e);
            bundle.putString("swanAppId", d.a.h0.a.b1.d.c.d.f41431f);
            bundle.putParcelableArrayList("mediaModels", d.a.h0.a.b1.d.c.e.e());
            bundle.putString("swanTmpPath", d.a.h0.a.b1.d.c.d.j);
            d.a.h0.a.b1.d.c.d.g(a.this.f41380e, bundle);
        }

        @Override // d.a.h0.a.b1.d.d.b
        public void b(String str) {
        }
    }

    /* loaded from: classes3.dex */
    public class g implements View.OnClickListener {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ MediaModel f41391e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ j f41392f;

        public g(MediaModel mediaModel, j jVar) {
            this.f41391e = mediaModel;
            this.f41392f = jVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            a.this.l(this.f41391e, this.f41392f);
        }
    }

    /* loaded from: classes3.dex */
    public class h implements View.OnClickListener {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ MediaModel f41394e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ int f41395f;

        public h(MediaModel mediaModel, int i2) {
            this.f41394e = mediaModel;
            this.f41395f = i2;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            a.this.j(this.f41394e, this.f41395f);
        }
    }

    /* loaded from: classes3.dex */
    public class i implements View.OnClickListener {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ VideoModel f41397e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ MediaModel f41398f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ int f41399g;

        public i(VideoModel videoModel, MediaModel mediaModel, int i2) {
            this.f41397e = videoModel;
            this.f41398f = mediaModel;
            this.f41399g = i2;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (a.this.s(this.f41397e.b()) && !a.this.n(this.f41397e.j())) {
                a.this.j(this.f41398f, this.f41399g);
            }
        }
    }

    /* loaded from: classes3.dex */
    public class j {

        /* renamed from: a  reason: collision with root package name */
        public SimpleDraweeView f41401a;

        /* renamed from: b  reason: collision with root package name */
        public ImageView f41402b;

        /* renamed from: c  reason: collision with root package name */
        public TextView f41403c;

        /* renamed from: d  reason: collision with root package name */
        public ImageView f41404d;

        /* renamed from: e  reason: collision with root package name */
        public View f41405e;

        /* renamed from: f  reason: collision with root package name */
        public View f41406f;

        /* renamed from: g  reason: collision with root package name */
        public TextView f41407g;

        /* renamed from: h  reason: collision with root package name */
        public View f41408h;

        public j(a aVar, View view) {
            this.f41401a = (SimpleDraweeView) view.findViewById(d.a.h0.a.f.album_item_img);
            this.f41404d = (ImageView) view.findViewById(d.a.h0.a.f.album_item_select_checkbox);
            this.f41403c = (TextView) view.findViewById(d.a.h0.a.f.album_item_select_number);
            this.f41406f = view.findViewById(d.a.h0.a.f.album_item_selected_check);
            this.f41405e = view.findViewById(d.a.h0.a.f.album_item_select_circle_view);
            this.f41402b = (ImageView) view.findViewById(d.a.h0.a.f.album_item_unable_shadow);
            this.f41408h = view.findViewById(d.a.h0.a.f.album_item_tip_bg);
            this.f41407g = (TextView) view.findViewById(d.a.h0.a.f.album_item_right_bottom_tip);
        }
    }

    public a(Activity activity) {
        this.f41380e = activity;
        int m = h0.m(this.f41380e);
        int l = h0.l(this.f41380e);
        this.f41383h = m / 4;
        this.f41384i = l / 4;
        this.j = new FrameLayout.LayoutParams((m - h0.e(this.f41380e, 10.0f)) / 4, (m - h0.e(this.f41380e, 10.0f)) / 4);
    }

    public final void A(j jVar, View view) {
        Resources resources = this.f41380e.getResources();
        view.setBackgroundColor(resources.getColor(d.a.h0.a.c.aiapps_white));
        jVar.f41401a.setBackgroundColor(resources.getColor(d.a.h0.a.c.swanapp_album_item_select_bg));
        jVar.f41403c.setTextColor(resources.getColor(d.a.h0.a.c.swanapp_album_select_number_color));
        jVar.f41408h.setBackground(resources.getDrawable(d.a.h0.a.e.swanapp_album_item_duration_bg));
        jVar.f41407g.setTextColor(resources.getColor(d.a.h0.a.c.aiapps_white));
        jVar.f41402b.setBackgroundColor(resources.getColor(d.a.h0.a.c.swanapp_album_unenable_shadow_color));
        jVar.f41401a.setLayoutParams(this.j);
        jVar.f41402b.setLayoutParams(this.j);
        jVar.f41402b.setVisibility(8);
        jVar.f41403c.setVisibility(8);
        jVar.f41406f.setVisibility(8);
        jVar.f41408h.setVisibility(8);
        jVar.f41406f.setVisibility(0);
        jVar.f41404d.setImageResource(d.a.h0.a.e.swanapp_album_unselect_thumb_icon);
        jVar.f41408h.setVisibility(0);
        FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) jVar.f41408h.getLayoutParams();
        layoutParams.width = this.f41380e.getResources().getDimensionPixelSize(d.a.h0.a.d.swanapp_album_item_tip_width);
        layoutParams.height = this.f41380e.getResources().getDimensionPixelSize(d.a.h0.a.d.swanapp_album_item_time_height);
        jVar.f41408h.setLayoutParams(layoutParams);
    }

    @Override // android.widget.Adapter
    public int getCount() {
        return d.a.h0.a.b1.d.c.d.f41433h ? this.f41381f.size() + 1 : this.f41381f.size();
    }

    @Override // android.widget.Adapter
    public Object getItem(int i2) {
        if (d.a.h0.a.b1.d.c.d.f41433h) {
            if (i2 == 0) {
                return null;
            }
            return this.f41381f.get(i2 - 1);
        }
        return this.f41381f.get(i2);
    }

    @Override // android.widget.Adapter
    public long getItemId(int i2) {
        return i2;
    }

    @Override // android.widget.BaseAdapter, android.widget.Adapter
    public int getItemViewType(int i2) {
        return (d.a.h0.a.b1.d.c.d.f41433h && i2 == 0) ? 0 : 1;
    }

    @Override // android.widget.Adapter
    public View getView(int i2, View view, ViewGroup viewGroup) {
        j jVar;
        if (getItemViewType(i2) == 0) {
            View inflate = LayoutInflater.from(this.f41380e).inflate(d.a.h0.a.g.swanapp_album_camera_item, (ViewGroup) null, false);
            r(inflate);
            return inflate;
        }
        if (view == null) {
            view = LayoutInflater.from(this.f41380e).inflate(d.a.h0.a.g.swanapp_album_select_item, (ViewGroup) null);
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
        if (d.a.h0.a.b1.d.c.d.f(d.a.h0.a.b1.d.c.d.f41429d, mediaModel)) {
            return;
        }
        if (d.a.h0.a.b1.d.c.d.f41433h) {
            i2--;
        }
        Bundle bundle = new Bundle();
        bundle.putBoolean("compressed", d.a.h0.a.b1.d.c.d.f41430e);
        bundle.putString("swanAppId", d.a.h0.a.b1.d.c.d.f41431f);
        bundle.putString("mode", d.a.h0.a.b1.d.c.d.f41429d);
        bundle.putString("previewFrom", "clickItem");
        bundle.putInt("previewPosition", i2);
        d.a.h0.a.b1.d.c.d.k(this.f41380e, bundle);
    }

    public final void k() {
        if (d.a.h0.a.b1.d.c.e.d() >= d.a.h0.a.b1.d.c.d.f41428c) {
            d.a.h0.a.b1.d.c.d.j(d.a.h0.a.b1.d.c.d.f41429d);
        } else if (f0.b() < 52428800) {
            d.a.h0.a.q1.b.f.d.f(AppRuntime.getAppContext(), this.f41380e.getResources().getString(d.a.h0.a.h.swanapp_album_camera_no_storage)).C();
        } else {
            p(this.f41380e);
        }
    }

    public final void l(MediaModel mediaModel, j jVar) {
        int d2 = d.a.h0.a.b1.d.c.e.d();
        if (!d.a.h0.a.b1.d.c.e.f(mediaModel)) {
            if (d2 >= d.a.h0.a.b1.d.c.d.f41428c) {
                d.a.h0.a.b1.d.c.d.j(d.a.h0.a.b1.d.c.d.f41429d);
                return;
            } else if (d2 <= 0 || !TextUtils.equals(d.a.h0.a.b1.d.c.d.f41429d, "single") || TextUtils.equals(d.a.h0.a.b1.d.c.e.b(), mediaModel.e())) {
                jVar.f41404d.setImageResource(d.a.h0.a.e.swanapp_album_select_icon_bg);
                jVar.f41403c.setVisibility(0);
                jVar.f41403c.setText(String.valueOf(d.a.h0.a.b1.d.c.e.c(mediaModel) + 1));
                d.a.h0.a.b1.d.c.e.i(mediaModel);
                jVar.f41405e.startAnimation(AnimationUtils.loadAnimation(this.f41380e, d.a.h0.a.a.swanapp_album_checkshake));
                d.a.h0.a.b1.d.d.e eVar = this.f41382g;
                if (eVar != null) {
                    eVar.a(d2);
                }
                notifyDataSetChanged();
                return;
            } else {
                d.a.h0.a.q1.b.f.d.e(this.f41380e, d.a.h0.a.h.swanapp_album_select_single).C();
                return;
            }
        }
        d.a.h0.a.b1.d.c.e.h(mediaModel);
        jVar.f41404d.setImageResource(d.a.h0.a.e.swanapp_album_unselect_thumb_icon);
        jVar.f41403c.setVisibility(8);
        d.a.h0.a.b1.d.d.e eVar2 = this.f41382g;
        if (eVar2 != null) {
            eVar2.a(d2);
        }
        notifyDataSetChanged();
    }

    public final void m() {
        if (d.a.h0.a.b1.d.c.e.d() >= d.a.h0.a.b1.d.c.d.f41428c) {
            d.a.h0.a.b1.d.c.d.j(d.a.h0.a.b1.d.c.d.f41429d);
        } else {
            q(this.f41380e);
        }
    }

    public final boolean n(long j2) {
        if (j2 < 3000) {
            d.a.h0.a.q1.b.f.d.f(AppRuntime.getAppContext(), this.f41380e.getString(d.a.h0.a.h.swanapp_album_video_duration_min)).C();
            return true;
        } else if (j2 > 300000) {
            d.a.h0.a.q1.b.f.d.f(AppRuntime.getAppContext(), this.f41380e.getString(d.a.h0.a.h.swanapp_album_video_duration_max)).C();
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
            return this.f41380e.getString(d.a.h0.a.h.swanapp_video_duration, new Object[]{format, format2});
        }
        return this.f41380e.getString(d.a.h0.a.h.swanapp_video_duration_hour, new Object[]{String.format(Locale.getDefault(), "%02d", Long.valueOf(j4)), format, format2});
    }

    public final void p(Context context) {
        d.a.h0.a.k1.a.a(PermissionRequest.RESOURCE_VIDEO_CAPTURE, new String[]{PermissionRequest.RESOURCE_VIDEO_CAPTURE}, 1, context, new e());
    }

    public final void q(Context context) {
        d.a.h0.a.k1.a.a(PermissionRequest.RESOURCE_VIDEO_CAPTURE, new String[]{PermissionRequest.RESOURCE_VIDEO_CAPTURE}, 1, context, new c());
    }

    public final void r(View view) {
        view.findViewById(d.a.h0.a.f.album_camera_enter).setLayoutParams(this.j);
        view.setTag(null);
        view.setClickable(true);
        ImageView imageView = (ImageView) view.findViewById(d.a.h0.a.f.album_camera_icon);
        if (TextUtils.equals(d.a.h0.a.b1.d.c.d.f41427b, "Image")) {
            imageView.setImageResource(d.a.h0.a.e.swanapp_album_camera_item_selector);
            view.setOnClickListener(new View$OnClickListenerC0577a());
            return;
        }
        imageView.setImageResource(d.a.h0.a.e.swanapp_album_camera_video_selector);
        view.setOnClickListener(new b());
    }

    public final boolean s(String str) {
        String str2;
        try {
            MediaMetadataRetriever mediaMetadataRetriever = new MediaMetadataRetriever();
            mediaMetadataRetriever.setDataSource(str);
            str2 = mediaMetadataRetriever.extractMetadata(12);
        } catch (Exception e2) {
            if (d.a.h0.a.b1.d.c.c.f41422a) {
                e2.printStackTrace();
            }
            str2 = "";
        }
        if (!TextUtils.isEmpty(str2) && str2.startsWith(FileUtils.VIDEO_FILE_START)) {
            return TextUtils.equals("video/mp4", str2) || TextUtils.equals("video/3gp", str2) || TextUtils.equals("video/webm", str2) || TextUtils.equals("video/mkv", str2);
        }
        d.a.h0.a.q1.b.f.d.f(AppRuntime.getAppContext(), this.f41380e.getString(d.a.h0.a.h.swanapp_album_video_format)).C();
        return false;
    }

    public final void t() {
        d.a.h0.a.b1.d.c.b.e(this.f41380e, d.a.h0.a.b1.d.c.d.f41431f, d.a.h0.a.b1.d.c.d.f41432g, d.a.h0.a.b1.d.c.d.f41434i, new f());
    }

    public final void u() {
        d.a.h0.a.b1.d.c.b.f(this.f41380e, d.a.h0.a.b1.d.c.d.f41431f, new d());
    }

    public final void v(MediaModel mediaModel, j jVar, int i2) {
        if (d.a.h0.a.b1.d.c.e.f(mediaModel)) {
            jVar.f41404d.setImageResource(d.a.h0.a.e.swanapp_album_select_icon_bg);
            jVar.f41403c.setVisibility(0);
            jVar.f41403c.setText(String.valueOf(d.a.h0.a.b1.d.c.e.c(mediaModel) + 1));
        }
        if (d.a.h0.a.b1.d.c.d.f(d.a.h0.a.b1.d.c.d.f41429d, mediaModel)) {
            jVar.f41402b.setVisibility(0);
        } else {
            jVar.f41402b.setVisibility(8);
        }
        if (!d.a.h0.a.b1.d.c.c.f41425d) {
            jVar.f41408h.setVisibility(8);
        } else if (d.a.h0.a.b1.d.c.d.d(mediaModel.b())) {
            jVar.f41407g.setText(this.f41380e.getString(d.a.h0.a.h.swanapp_album_gif_photo));
        } else if (d.a.h0.a.b1.d.c.d.e(mediaModel.b())) {
            jVar.f41407g.setText(this.f41380e.getString(d.a.h0.a.h.swanapp_album_large_photo));
        } else {
            jVar.f41408h.setVisibility(8);
        }
        jVar.f41406f.setOnClickListener(new g(mediaModel, jVar));
        jVar.f41401a.setOnClickListener(new h(mediaModel, i2));
    }

    public final void w(MediaModel mediaModel, j jVar, int i2) {
        if (mediaModel instanceof VideoModel) {
            VideoModel videoModel = (VideoModel) mediaModel;
            jVar.f41408h.setVisibility(0);
            FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) jVar.f41408h.getLayoutParams();
            if ((videoModel.j() / 3600) / 1000 > 0) {
                layoutParams.width = this.f41380e.getResources().getDimensionPixelSize(d.a.h0.a.d.swanapp_album_item_longtime_width);
            } else {
                layoutParams.width = this.f41380e.getResources().getDimensionPixelSize(d.a.h0.a.d.swanapp_album_item_time_width);
            }
            layoutParams.height = this.f41380e.getResources().getDimensionPixelSize(d.a.h0.a.d.swanapp_album_item_time_height);
            jVar.f41408h.setLayoutParams(layoutParams);
            jVar.f41407g.setText(o(videoModel.j()));
            jVar.f41401a.setOnClickListener(new i(videoModel, mediaModel, i2));
        }
    }

    public void x(ArrayList<MediaModel> arrayList) {
        if (this.f41381f.size() > 0) {
            this.f41381f.clear();
        }
        this.f41381f.addAll(arrayList);
        d.a.h0.a.b1.d.c.d.i(this.f41381f);
        notifyDataSetChanged();
    }

    public final void y(String str, j jVar) {
        ImageRequestBuilder newBuilderWithSource = ImageRequestBuilder.newBuilderWithSource(Uri.fromFile(new File(str)));
        newBuilderWithSource.setResizeOptions(new ResizeOptions((int) (this.f41383h / 2.0f), (int) (this.f41384i / 2.0f)));
        newBuilderWithSource.setLocalThumbnailPreviewsEnabled(true);
        newBuilderWithSource.setImageDecodeOptions(ImageDecodeOptions.newBuilder().setForceStaticImage(true).build());
        jVar.f41401a.setController(Fresco.newDraweeControllerBuilder().setImageRequest(newBuilderWithSource.build()).setAutoPlayAnimations(false).setOldController(jVar.f41401a.getController()).build());
    }

    public void z(d.a.h0.a.b1.d.d.e eVar) {
        this.f41382g = eVar;
    }
}
