package d.a.m0.a.i1.d.b;

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
import com.facebook.drawee.controller.AbstractDraweeController;
import com.facebook.drawee.generic.GenericDraweeHierarchy;
import com.facebook.drawee.interfaces.DraweeHierarchy;
import com.facebook.drawee.view.SimpleDraweeView;
import com.facebook.imagepipeline.common.ImageDecodeOptions;
import com.facebook.imagepipeline.common.ResizeOptions;
import com.facebook.imagepipeline.request.ImageRequestBuilder;
import com.sina.weibo.sdk.utils.FileUtils;
import d.a.m0.a.v2.k0;
import d.a.m0.a.v2.n0;
import java.io.File;
import java.util.ArrayList;
import java.util.Locale;
/* loaded from: classes3.dex */
public class a extends BaseAdapter {

    /* renamed from: e  reason: collision with root package name */
    public Activity f46605e;

    /* renamed from: f  reason: collision with root package name */
    public ArrayList<MediaModel> f46606f = new ArrayList<>();

    /* renamed from: g  reason: collision with root package name */
    public d.a.m0.a.i1.d.d.e f46607g;

    /* renamed from: h  reason: collision with root package name */
    public int f46608h;

    /* renamed from: i  reason: collision with root package name */
    public int f46609i;
    public FrameLayout.LayoutParams j;

    /* renamed from: d.a.m0.a.i1.d.b.a$a  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public class View$OnClickListenerC0769a implements View.OnClickListener {
        public View$OnClickListenerC0769a() {
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
    public class c implements d.a.m0.a.s1.f {
        public c() {
        }

        @Override // d.a.m0.a.s1.f
        public void a(String str) {
            a.this.u();
        }

        @Override // d.a.m0.a.s1.f
        public void b(int i2, String str) {
        }
    }

    /* loaded from: classes3.dex */
    public class d implements d.a.m0.a.i1.d.d.b {
        public d() {
        }

        @Override // d.a.m0.a.i1.d.d.b
        public void a(File file) {
            ImageModel imageModel = new ImageModel(file.getAbsolutePath());
            imageModel.g(file.length());
            d.a.m0.a.i1.d.c.e.i(imageModel);
            Bundle bundle = new Bundle();
            bundle.putBoolean("compressed", d.a.m0.a.i1.d.c.d.f46655e);
            bundle.putString("swanAppId", d.a.m0.a.i1.d.c.d.f46656f);
            bundle.putParcelableArrayList("mediaModels", d.a.m0.a.i1.d.c.e.e());
            bundle.putString("swanTmpPath", d.a.m0.a.i1.d.c.d.j);
            d.a.m0.a.i1.d.c.d.g(a.this.f46605e, bundle);
        }

        @Override // d.a.m0.a.i1.d.d.b
        public void b(String str) {
        }
    }

    /* loaded from: classes3.dex */
    public class e implements d.a.m0.a.s1.f {
        public e() {
        }

        @Override // d.a.m0.a.s1.f
        public void a(String str) {
            a.this.t();
        }

        @Override // d.a.m0.a.s1.f
        public void b(int i2, String str) {
        }
    }

    /* loaded from: classes3.dex */
    public class f implements d.a.m0.a.i1.d.d.b {
        public f() {
        }

        @Override // d.a.m0.a.i1.d.d.b
        public void a(File file) {
            d.a.m0.a.i1.d.c.e.i(d.a.m0.a.i1.d.c.b.c(file));
            Bundle bundle = new Bundle();
            bundle.putBoolean("compressed", d.a.m0.a.i1.d.c.d.f46655e);
            bundle.putString("swanAppId", d.a.m0.a.i1.d.c.d.f46656f);
            bundle.putParcelableArrayList("mediaModels", d.a.m0.a.i1.d.c.e.e());
            bundle.putString("swanTmpPath", d.a.m0.a.i1.d.c.d.j);
            d.a.m0.a.i1.d.c.d.g(a.this.f46605e, bundle);
        }

        @Override // d.a.m0.a.i1.d.d.b
        public void b(String str) {
        }
    }

    /* loaded from: classes3.dex */
    public class g implements View.OnClickListener {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ MediaModel f46616e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ j f46617f;

        public g(MediaModel mediaModel, j jVar) {
            this.f46616e = mediaModel;
            this.f46617f = jVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            a.this.l(this.f46616e, this.f46617f);
        }
    }

    /* loaded from: classes3.dex */
    public class h implements View.OnClickListener {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ MediaModel f46619e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ int f46620f;

        public h(MediaModel mediaModel, int i2) {
            this.f46619e = mediaModel;
            this.f46620f = i2;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            a.this.j(this.f46619e, this.f46620f);
        }
    }

    /* loaded from: classes3.dex */
    public class i implements View.OnClickListener {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ VideoModel f46622e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ MediaModel f46623f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ int f46624g;

        public i(VideoModel videoModel, MediaModel mediaModel, int i2) {
            this.f46622e = videoModel;
            this.f46623f = mediaModel;
            this.f46624g = i2;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (a.this.s(this.f46622e.b()) && !a.this.n(this.f46622e.j())) {
                a.this.j(this.f46623f, this.f46624g);
            }
        }
    }

    /* loaded from: classes3.dex */
    public class j {

        /* renamed from: a  reason: collision with root package name */
        public SimpleDraweeView f46626a;

        /* renamed from: b  reason: collision with root package name */
        public ImageView f46627b;

        /* renamed from: c  reason: collision with root package name */
        public TextView f46628c;

        /* renamed from: d  reason: collision with root package name */
        public ImageView f46629d;

        /* renamed from: e  reason: collision with root package name */
        public View f46630e;

        /* renamed from: f  reason: collision with root package name */
        public View f46631f;

        /* renamed from: g  reason: collision with root package name */
        public TextView f46632g;

        /* renamed from: h  reason: collision with root package name */
        public View f46633h;

        public j(a aVar, View view) {
            this.f46626a = (SimpleDraweeView) view.findViewById(d.a.m0.a.f.album_item_img);
            this.f46629d = (ImageView) view.findViewById(d.a.m0.a.f.album_item_select_checkbox);
            this.f46628c = (TextView) view.findViewById(d.a.m0.a.f.album_item_select_number);
            this.f46631f = view.findViewById(d.a.m0.a.f.album_item_selected_check);
            this.f46630e = view.findViewById(d.a.m0.a.f.album_item_select_circle_view);
            this.f46627b = (ImageView) view.findViewById(d.a.m0.a.f.album_item_unable_shadow);
            this.f46633h = view.findViewById(d.a.m0.a.f.album_item_tip_bg);
            this.f46632g = (TextView) view.findViewById(d.a.m0.a.f.album_item_right_bottom_tip);
        }
    }

    public a(Activity activity) {
        this.f46605e = activity;
        int o = n0.o(this.f46605e);
        int n = n0.n(this.f46605e);
        this.f46608h = o / 4;
        this.f46609i = n / 4;
        this.j = new FrameLayout.LayoutParams((o - n0.f(this.f46605e, 10.0f)) / 4, (o - n0.f(this.f46605e, 10.0f)) / 4);
    }

    public final void A(j jVar, View view) {
        Resources resources = this.f46605e.getResources();
        view.setBackgroundColor(-1);
        jVar.f46626a.setBackgroundColor(resources.getColor(d.a.m0.a.c.swanapp_album_item_select_bg));
        jVar.f46628c.setTextColor(resources.getColor(d.a.m0.a.c.swanapp_album_select_number_color));
        jVar.f46633h.setBackground(resources.getDrawable(d.a.m0.a.e.swanapp_album_item_duration_bg));
        jVar.f46632g.setTextColor(-1);
        jVar.f46627b.setBackgroundColor(resources.getColor(d.a.m0.a.c.swanapp_album_unenable_shadow_color));
        jVar.f46626a.setLayoutParams(this.j);
        jVar.f46627b.setLayoutParams(this.j);
        jVar.f46627b.setVisibility(8);
        jVar.f46628c.setVisibility(8);
        jVar.f46631f.setVisibility(8);
        jVar.f46633h.setVisibility(8);
        jVar.f46631f.setVisibility(0);
        jVar.f46629d.setImageResource(d.a.m0.a.e.swanapp_album_unselect_thumb_icon);
        jVar.f46633h.setVisibility(0);
        FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) jVar.f46633h.getLayoutParams();
        layoutParams.width = this.f46605e.getResources().getDimensionPixelSize(d.a.m0.a.d.swanapp_album_item_tip_width);
        layoutParams.height = this.f46605e.getResources().getDimensionPixelSize(d.a.m0.a.d.swanapp_album_item_time_height);
        jVar.f46633h.setLayoutParams(layoutParams);
    }

    @Override // android.widget.Adapter
    public int getCount() {
        return d.a.m0.a.i1.d.c.d.f46658h ? this.f46606f.size() + 1 : this.f46606f.size();
    }

    @Override // android.widget.Adapter
    public Object getItem(int i2) {
        if (d.a.m0.a.i1.d.c.d.f46658h) {
            if (i2 == 0) {
                return null;
            }
            return this.f46606f.get(i2 - 1);
        }
        return this.f46606f.get(i2);
    }

    @Override // android.widget.Adapter
    public long getItemId(int i2) {
        return i2;
    }

    @Override // android.widget.BaseAdapter, android.widget.Adapter
    public int getItemViewType(int i2) {
        return (d.a.m0.a.i1.d.c.d.f46658h && i2 == 0) ? 0 : 1;
    }

    @Override // android.widget.Adapter
    public View getView(int i2, View view, ViewGroup viewGroup) {
        j jVar;
        if (getItemViewType(i2) == 0) {
            View inflate = LayoutInflater.from(this.f46605e).inflate(d.a.m0.a.g.swanapp_album_camera_item, (ViewGroup) null, false);
            r(inflate);
            return inflate;
        }
        if (view == null) {
            view = LayoutInflater.from(this.f46605e).inflate(d.a.m0.a.g.swanapp_album_select_item, (ViewGroup) null);
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
        if (d.a.m0.a.i1.d.c.d.f(d.a.m0.a.i1.d.c.d.f46654d, mediaModel)) {
            return;
        }
        if (d.a.m0.a.i1.d.c.d.f46658h) {
            i2--;
        }
        Bundle bundle = new Bundle();
        bundle.putBoolean("compressed", d.a.m0.a.i1.d.c.d.f46655e);
        bundle.putString("swanAppId", d.a.m0.a.i1.d.c.d.f46656f);
        bundle.putString("mode", d.a.m0.a.i1.d.c.d.f46654d);
        bundle.putString("previewFrom", "clickItem");
        bundle.putInt("previewPosition", i2);
        d.a.m0.a.i1.d.c.d.k(this.f46605e, bundle);
    }

    public final void k() {
        if (d.a.m0.a.i1.d.c.e.d() >= d.a.m0.a.i1.d.c.d.f46653c) {
            d.a.m0.a.i1.d.c.d.j(d.a.m0.a.i1.d.c.d.f46654d);
        } else if (k0.c() < 52428800) {
            d.a.m0.a.z1.b.f.e.g(AppRuntime.getAppContext(), this.f46605e.getResources().getString(d.a.m0.a.h.swanapp_album_camera_no_storage)).F();
        } else {
            p(this.f46605e);
        }
    }

    public final void l(MediaModel mediaModel, j jVar) {
        int d2 = d.a.m0.a.i1.d.c.e.d();
        if (!d.a.m0.a.i1.d.c.e.f(mediaModel)) {
            if (d2 >= d.a.m0.a.i1.d.c.d.f46653c) {
                d.a.m0.a.i1.d.c.d.j(d.a.m0.a.i1.d.c.d.f46654d);
                return;
            } else if (d2 > 0 && TextUtils.equals(d.a.m0.a.i1.d.c.d.f46654d, "single") && !TextUtils.equals(d.a.m0.a.i1.d.c.e.b(), mediaModel.e())) {
                d.a.m0.a.z1.b.f.e.f(this.f46605e, d.a.m0.a.h.swanapp_album_select_single).F();
                return;
            } else if (mediaModel.c() <= 52428800 || !TextUtils.equals(mediaModel.e(), "image")) {
                jVar.f46629d.setImageResource(d.a.m0.a.e.swanapp_album_select_icon_bg);
                jVar.f46628c.setVisibility(0);
                jVar.f46628c.setText(String.valueOf(d.a.m0.a.i1.d.c.e.c(mediaModel) + 1));
                d.a.m0.a.i1.d.c.e.i(mediaModel);
                jVar.f46630e.startAnimation(AnimationUtils.loadAnimation(this.f46605e, d.a.m0.a.a.swanapp_album_checkshake));
                d.a.m0.a.i1.d.d.e eVar = this.f46607g;
                if (eVar != null) {
                    eVar.a(d2);
                }
                notifyDataSetChanged();
                return;
            } else {
                d.a.m0.a.z1.b.f.e.f(this.f46605e, d.a.m0.a.h.swanapp_album_photo_too_big).F();
                return;
            }
        }
        d.a.m0.a.i1.d.c.e.h(mediaModel);
        jVar.f46629d.setImageResource(d.a.m0.a.e.swanapp_album_unselect_thumb_icon);
        jVar.f46628c.setVisibility(8);
        d.a.m0.a.i1.d.d.e eVar2 = this.f46607g;
        if (eVar2 != null) {
            eVar2.a(d2);
        }
        notifyDataSetChanged();
    }

    public final void m() {
        if (d.a.m0.a.i1.d.c.e.d() >= d.a.m0.a.i1.d.c.d.f46653c) {
            d.a.m0.a.i1.d.c.d.j(d.a.m0.a.i1.d.c.d.f46654d);
        } else {
            q(this.f46605e);
        }
    }

    public final boolean n(long j2) {
        if (j2 < 3000) {
            d.a.m0.a.z1.b.f.e.g(AppRuntime.getAppContext(), this.f46605e.getString(d.a.m0.a.h.swanapp_album_video_duration_min)).F();
            return true;
        } else if (j2 > 300000) {
            d.a.m0.a.z1.b.f.e.g(AppRuntime.getAppContext(), this.f46605e.getString(d.a.m0.a.h.swanapp_album_video_duration_max)).F();
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
            return this.f46605e.getString(d.a.m0.a.h.swanapp_video_duration, new Object[]{format, format2});
        }
        return this.f46605e.getString(d.a.m0.a.h.swanapp_video_duration_hour, new Object[]{String.format(Locale.getDefault(), "%02d", Long.valueOf(j4)), format, format2});
    }

    public final void p(Context context) {
        d.a.m0.a.s1.e.e(PermissionRequest.RESOURCE_VIDEO_CAPTURE, new String[]{PermissionRequest.RESOURCE_VIDEO_CAPTURE}, 1, context, new e());
    }

    public final void q(Context context) {
        d.a.m0.a.s1.e.e(PermissionRequest.RESOURCE_VIDEO_CAPTURE, new String[]{PermissionRequest.RESOURCE_VIDEO_CAPTURE}, 1, context, new c());
    }

    public final void r(View view) {
        view.findViewById(d.a.m0.a.f.album_camera_enter).setLayoutParams(this.j);
        view.setTag(null);
        view.setClickable(true);
        ImageView imageView = (ImageView) view.findViewById(d.a.m0.a.f.album_camera_icon);
        if (TextUtils.equals(d.a.m0.a.i1.d.c.d.f46652b, "Image")) {
            imageView.setImageResource(d.a.m0.a.e.swanapp_album_camera_item_selector);
            view.setOnClickListener(new View$OnClickListenerC0769a());
            return;
        }
        imageView.setImageResource(d.a.m0.a.e.swanapp_album_camera_video_selector);
        view.setOnClickListener(new b());
    }

    /* JADX WARN: Removed duplicated region for block: B:38:0x0020 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final boolean s(String str) {
        String str2;
        MediaMetadataRetriever mediaMetadataRetriever;
        MediaMetadataRetriever mediaMetadataRetriever2 = null;
        try {
            mediaMetadataRetriever = new MediaMetadataRetriever();
            try {
                mediaMetadataRetriever.setDataSource(str);
                str2 = mediaMetadataRetriever.extractMetadata(12);
            } catch (Exception e2) {
                e = e2;
                mediaMetadataRetriever2 = mediaMetadataRetriever;
                if (d.a.m0.a.i1.d.c.c.f46647a) {
                    e.printStackTrace();
                }
                str2 = "";
                mediaMetadataRetriever = mediaMetadataRetriever2;
                if (mediaMetadataRetriever != null) {
                }
                if (TextUtils.isEmpty(str2)) {
                }
                d.a.m0.a.z1.b.f.e.g(AppRuntime.getAppContext(), this.f46605e.getString(d.a.m0.a.h.swanapp_album_video_format)).F();
                return false;
            }
        } catch (Exception e3) {
            e = e3;
        }
        if (mediaMetadataRetriever != null) {
            try {
                mediaMetadataRetriever.close();
            } catch (Exception e4) {
                if (d.a.m0.a.i1.d.c.c.f46647a) {
                    e4.printStackTrace();
                }
            }
        }
        if (TextUtils.isEmpty(str2) && str2.startsWith(FileUtils.VIDEO_FILE_START)) {
            return TextUtils.equals("video/mp4", str2) || TextUtils.equals("video/3gp", str2) || TextUtils.equals("video/webm", str2) || TextUtils.equals("video/mkv", str2);
        }
        d.a.m0.a.z1.b.f.e.g(AppRuntime.getAppContext(), this.f46605e.getString(d.a.m0.a.h.swanapp_album_video_format)).F();
        return false;
    }

    public final void t() {
        d.a.m0.a.i1.d.c.b.e(this.f46605e, d.a.m0.a.i1.d.c.d.f46656f, d.a.m0.a.i1.d.c.d.f46657g, d.a.m0.a.i1.d.c.d.f46659i, new f());
    }

    public final void u() {
        d.a.m0.a.i1.d.c.b.f(this.f46605e, d.a.m0.a.i1.d.c.d.f46656f, new d());
    }

    public final void v(MediaModel mediaModel, j jVar, int i2) {
        if (d.a.m0.a.i1.d.c.e.f(mediaModel)) {
            jVar.f46629d.setImageResource(d.a.m0.a.e.swanapp_album_select_icon_bg);
            jVar.f46628c.setVisibility(0);
            jVar.f46628c.setText(String.valueOf(d.a.m0.a.i1.d.c.e.c(mediaModel) + 1));
        }
        if (d.a.m0.a.i1.d.c.d.f(d.a.m0.a.i1.d.c.d.f46654d, mediaModel)) {
            jVar.f46627b.setVisibility(0);
        } else {
            jVar.f46627b.setVisibility(8);
        }
        if (!d.a.m0.a.i1.d.c.c.f46650d) {
            jVar.f46633h.setVisibility(8);
        } else if (d.a.m0.a.i1.d.c.d.d(mediaModel.b())) {
            jVar.f46632g.setText(this.f46605e.getString(d.a.m0.a.h.swanapp_album_gif_photo));
        } else if (d.a.m0.a.i1.d.c.d.e(mediaModel.b())) {
            jVar.f46632g.setText(this.f46605e.getString(d.a.m0.a.h.swanapp_album_large_photo));
        } else {
            jVar.f46633h.setVisibility(8);
        }
        jVar.f46631f.setOnClickListener(new g(mediaModel, jVar));
        jVar.f46626a.setOnClickListener(new h(mediaModel, i2));
    }

    public final void w(MediaModel mediaModel, j jVar, int i2) {
        if (mediaModel instanceof VideoModel) {
            VideoModel videoModel = (VideoModel) mediaModel;
            jVar.f46633h.setVisibility(0);
            FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) jVar.f46633h.getLayoutParams();
            if ((videoModel.j() / 3600) / 1000 > 0) {
                layoutParams.width = this.f46605e.getResources().getDimensionPixelSize(d.a.m0.a.d.swanapp_album_item_longtime_width);
            } else {
                layoutParams.width = this.f46605e.getResources().getDimensionPixelSize(d.a.m0.a.d.swanapp_album_item_time_width);
            }
            layoutParams.height = this.f46605e.getResources().getDimensionPixelSize(d.a.m0.a.d.swanapp_album_item_time_height);
            jVar.f46633h.setLayoutParams(layoutParams);
            jVar.f46632g.setText(o(videoModel.j()));
            jVar.f46626a.setOnClickListener(new i(videoModel, mediaModel, i2));
        }
    }

    public void x(ArrayList<MediaModel> arrayList) {
        if (this.f46606f.size() > 0) {
            this.f46606f.clear();
        }
        this.f46606f.addAll(arrayList);
        d.a.m0.a.i1.d.c.d.i(this.f46606f);
        notifyDataSetChanged();
    }

    public final void y(String str, j jVar) {
        ImageRequestBuilder newBuilderWithSource = ImageRequestBuilder.newBuilderWithSource(Uri.fromFile(new File(str)));
        newBuilderWithSource.setResizeOptions(new ResizeOptions((int) (this.f46608h / 2.0f), (int) (this.f46609i / 2.0f)));
        newBuilderWithSource.setLocalThumbnailPreviewsEnabled(true);
        newBuilderWithSource.setImageDecodeOptions(ImageDecodeOptions.newBuilder().setForceStaticImage(true).build());
        AbstractDraweeController build = Fresco.newDraweeControllerBuilder().setImageRequest(newBuilderWithSource.build()).setAutoPlayAnimations(false).setOldController(jVar.f46626a.getController()).build();
        jVar.f46626a.setController(build);
        DraweeHierarchy hierarchy = build.getHierarchy();
        if (hierarchy instanceof GenericDraweeHierarchy) {
            d.a.m0.a.c1.a.y().c((GenericDraweeHierarchy) hierarchy, false);
        }
    }

    public void z(d.a.m0.a.i1.d.d.e eVar) {
        this.f46607g = eVar;
    }
}
