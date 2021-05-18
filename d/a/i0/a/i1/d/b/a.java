package d.a.i0.a.i1.d.b;

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
import d.a.i0.a.v2.k0;
import d.a.i0.a.v2.n0;
import java.io.File;
import java.util.ArrayList;
import java.util.Locale;
/* loaded from: classes3.dex */
public class a extends BaseAdapter {

    /* renamed from: e  reason: collision with root package name */
    public Activity f42647e;

    /* renamed from: f  reason: collision with root package name */
    public ArrayList<MediaModel> f42648f = new ArrayList<>();

    /* renamed from: g  reason: collision with root package name */
    public d.a.i0.a.i1.d.d.e f42649g;

    /* renamed from: h  reason: collision with root package name */
    public int f42650h;

    /* renamed from: i  reason: collision with root package name */
    public int f42651i;
    public FrameLayout.LayoutParams j;

    /* renamed from: d.a.i0.a.i1.d.b.a$a  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public class View$OnClickListenerC0699a implements View.OnClickListener {
        public View$OnClickListenerC0699a() {
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
    public class c implements d.a.i0.a.s1.f {
        public c() {
        }

        @Override // d.a.i0.a.s1.f
        public void a(String str) {
            a.this.u();
        }

        @Override // d.a.i0.a.s1.f
        public void b(int i2, String str) {
        }
    }

    /* loaded from: classes3.dex */
    public class d implements d.a.i0.a.i1.d.d.b {
        public d() {
        }

        @Override // d.a.i0.a.i1.d.d.b
        public void a(File file) {
            ImageModel imageModel = new ImageModel(file.getAbsolutePath());
            imageModel.g(file.length());
            d.a.i0.a.i1.d.c.e.i(imageModel);
            Bundle bundle = new Bundle();
            bundle.putBoolean("compressed", d.a.i0.a.i1.d.c.d.f42697e);
            bundle.putString("swanAppId", d.a.i0.a.i1.d.c.d.f42698f);
            bundle.putParcelableArrayList("mediaModels", d.a.i0.a.i1.d.c.e.e());
            bundle.putString("swanTmpPath", d.a.i0.a.i1.d.c.d.j);
            d.a.i0.a.i1.d.c.d.g(a.this.f42647e, bundle);
        }

        @Override // d.a.i0.a.i1.d.d.b
        public void b(String str) {
        }
    }

    /* loaded from: classes3.dex */
    public class e implements d.a.i0.a.s1.f {
        public e() {
        }

        @Override // d.a.i0.a.s1.f
        public void a(String str) {
            a.this.t();
        }

        @Override // d.a.i0.a.s1.f
        public void b(int i2, String str) {
        }
    }

    /* loaded from: classes3.dex */
    public class f implements d.a.i0.a.i1.d.d.b {
        public f() {
        }

        @Override // d.a.i0.a.i1.d.d.b
        public void a(File file) {
            d.a.i0.a.i1.d.c.e.i(d.a.i0.a.i1.d.c.b.c(file));
            Bundle bundle = new Bundle();
            bundle.putBoolean("compressed", d.a.i0.a.i1.d.c.d.f42697e);
            bundle.putString("swanAppId", d.a.i0.a.i1.d.c.d.f42698f);
            bundle.putParcelableArrayList("mediaModels", d.a.i0.a.i1.d.c.e.e());
            bundle.putString("swanTmpPath", d.a.i0.a.i1.d.c.d.j);
            d.a.i0.a.i1.d.c.d.g(a.this.f42647e, bundle);
        }

        @Override // d.a.i0.a.i1.d.d.b
        public void b(String str) {
        }
    }

    /* loaded from: classes3.dex */
    public class g implements View.OnClickListener {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ MediaModel f42658e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ j f42659f;

        public g(MediaModel mediaModel, j jVar) {
            this.f42658e = mediaModel;
            this.f42659f = jVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            a.this.l(this.f42658e, this.f42659f);
        }
    }

    /* loaded from: classes3.dex */
    public class h implements View.OnClickListener {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ MediaModel f42661e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ int f42662f;

        public h(MediaModel mediaModel, int i2) {
            this.f42661e = mediaModel;
            this.f42662f = i2;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            a.this.j(this.f42661e, this.f42662f);
        }
    }

    /* loaded from: classes3.dex */
    public class i implements View.OnClickListener {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ VideoModel f42664e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ MediaModel f42665f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ int f42666g;

        public i(VideoModel videoModel, MediaModel mediaModel, int i2) {
            this.f42664e = videoModel;
            this.f42665f = mediaModel;
            this.f42666g = i2;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (a.this.s(this.f42664e.b()) && !a.this.n(this.f42664e.j())) {
                a.this.j(this.f42665f, this.f42666g);
            }
        }
    }

    /* loaded from: classes3.dex */
    public class j {

        /* renamed from: a  reason: collision with root package name */
        public SimpleDraweeView f42668a;

        /* renamed from: b  reason: collision with root package name */
        public ImageView f42669b;

        /* renamed from: c  reason: collision with root package name */
        public TextView f42670c;

        /* renamed from: d  reason: collision with root package name */
        public ImageView f42671d;

        /* renamed from: e  reason: collision with root package name */
        public View f42672e;

        /* renamed from: f  reason: collision with root package name */
        public View f42673f;

        /* renamed from: g  reason: collision with root package name */
        public TextView f42674g;

        /* renamed from: h  reason: collision with root package name */
        public View f42675h;

        public j(a aVar, View view) {
            this.f42668a = (SimpleDraweeView) view.findViewById(d.a.i0.a.f.album_item_img);
            this.f42671d = (ImageView) view.findViewById(d.a.i0.a.f.album_item_select_checkbox);
            this.f42670c = (TextView) view.findViewById(d.a.i0.a.f.album_item_select_number);
            this.f42673f = view.findViewById(d.a.i0.a.f.album_item_selected_check);
            this.f42672e = view.findViewById(d.a.i0.a.f.album_item_select_circle_view);
            this.f42669b = (ImageView) view.findViewById(d.a.i0.a.f.album_item_unable_shadow);
            this.f42675h = view.findViewById(d.a.i0.a.f.album_item_tip_bg);
            this.f42674g = (TextView) view.findViewById(d.a.i0.a.f.album_item_right_bottom_tip);
        }
    }

    public a(Activity activity) {
        this.f42647e = activity;
        int o = n0.o(this.f42647e);
        int n = n0.n(this.f42647e);
        this.f42650h = o / 4;
        this.f42651i = n / 4;
        this.j = new FrameLayout.LayoutParams((o - n0.f(this.f42647e, 10.0f)) / 4, (o - n0.f(this.f42647e, 10.0f)) / 4);
    }

    public final void A(j jVar, View view) {
        Resources resources = this.f42647e.getResources();
        view.setBackgroundColor(-1);
        jVar.f42668a.setBackgroundColor(resources.getColor(d.a.i0.a.c.swanapp_album_item_select_bg));
        jVar.f42670c.setTextColor(resources.getColor(d.a.i0.a.c.swanapp_album_select_number_color));
        jVar.f42675h.setBackground(resources.getDrawable(d.a.i0.a.e.swanapp_album_item_duration_bg));
        jVar.f42674g.setTextColor(-1);
        jVar.f42669b.setBackgroundColor(resources.getColor(d.a.i0.a.c.swanapp_album_unenable_shadow_color));
        jVar.f42668a.setLayoutParams(this.j);
        jVar.f42669b.setLayoutParams(this.j);
        jVar.f42669b.setVisibility(8);
        jVar.f42670c.setVisibility(8);
        jVar.f42673f.setVisibility(8);
        jVar.f42675h.setVisibility(8);
        jVar.f42673f.setVisibility(0);
        jVar.f42671d.setImageResource(d.a.i0.a.e.swanapp_album_unselect_thumb_icon);
        jVar.f42675h.setVisibility(0);
        FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) jVar.f42675h.getLayoutParams();
        layoutParams.width = this.f42647e.getResources().getDimensionPixelSize(d.a.i0.a.d.swanapp_album_item_tip_width);
        layoutParams.height = this.f42647e.getResources().getDimensionPixelSize(d.a.i0.a.d.swanapp_album_item_time_height);
        jVar.f42675h.setLayoutParams(layoutParams);
    }

    @Override // android.widget.Adapter
    public int getCount() {
        return d.a.i0.a.i1.d.c.d.f42700h ? this.f42648f.size() + 1 : this.f42648f.size();
    }

    @Override // android.widget.Adapter
    public Object getItem(int i2) {
        if (d.a.i0.a.i1.d.c.d.f42700h) {
            if (i2 == 0) {
                return null;
            }
            return this.f42648f.get(i2 - 1);
        }
        return this.f42648f.get(i2);
    }

    @Override // android.widget.Adapter
    public long getItemId(int i2) {
        return i2;
    }

    @Override // android.widget.BaseAdapter, android.widget.Adapter
    public int getItemViewType(int i2) {
        return (d.a.i0.a.i1.d.c.d.f42700h && i2 == 0) ? 0 : 1;
    }

    @Override // android.widget.Adapter
    public View getView(int i2, View view, ViewGroup viewGroup) {
        j jVar;
        if (getItemViewType(i2) == 0) {
            View inflate = LayoutInflater.from(this.f42647e).inflate(d.a.i0.a.g.swanapp_album_camera_item, (ViewGroup) null, false);
            r(inflate);
            return inflate;
        }
        if (view == null) {
            view = LayoutInflater.from(this.f42647e).inflate(d.a.i0.a.g.swanapp_album_select_item, (ViewGroup) null);
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
        if (d.a.i0.a.i1.d.c.d.f(d.a.i0.a.i1.d.c.d.f42696d, mediaModel)) {
            return;
        }
        if (d.a.i0.a.i1.d.c.d.f42700h) {
            i2--;
        }
        Bundle bundle = new Bundle();
        bundle.putBoolean("compressed", d.a.i0.a.i1.d.c.d.f42697e);
        bundle.putString("swanAppId", d.a.i0.a.i1.d.c.d.f42698f);
        bundle.putString("mode", d.a.i0.a.i1.d.c.d.f42696d);
        bundle.putString("previewFrom", "clickItem");
        bundle.putInt("previewPosition", i2);
        d.a.i0.a.i1.d.c.d.k(this.f42647e, bundle);
    }

    public final void k() {
        if (d.a.i0.a.i1.d.c.e.d() >= d.a.i0.a.i1.d.c.d.f42695c) {
            d.a.i0.a.i1.d.c.d.j(d.a.i0.a.i1.d.c.d.f42696d);
        } else if (k0.c() < 52428800) {
            d.a.i0.a.z1.b.f.e.g(AppRuntime.getAppContext(), this.f42647e.getResources().getString(d.a.i0.a.h.swanapp_album_camera_no_storage)).F();
        } else {
            p(this.f42647e);
        }
    }

    public final void l(MediaModel mediaModel, j jVar) {
        int d2 = d.a.i0.a.i1.d.c.e.d();
        if (!d.a.i0.a.i1.d.c.e.f(mediaModel)) {
            if (d2 >= d.a.i0.a.i1.d.c.d.f42695c) {
                d.a.i0.a.i1.d.c.d.j(d.a.i0.a.i1.d.c.d.f42696d);
                return;
            } else if (d2 > 0 && TextUtils.equals(d.a.i0.a.i1.d.c.d.f42696d, "single") && !TextUtils.equals(d.a.i0.a.i1.d.c.e.b(), mediaModel.e())) {
                d.a.i0.a.z1.b.f.e.f(this.f42647e, d.a.i0.a.h.swanapp_album_select_single).F();
                return;
            } else if (mediaModel.c() <= 52428800 || !TextUtils.equals(mediaModel.e(), "image")) {
                jVar.f42671d.setImageResource(d.a.i0.a.e.swanapp_album_select_icon_bg);
                jVar.f42670c.setVisibility(0);
                jVar.f42670c.setText(String.valueOf(d.a.i0.a.i1.d.c.e.c(mediaModel) + 1));
                d.a.i0.a.i1.d.c.e.i(mediaModel);
                jVar.f42672e.startAnimation(AnimationUtils.loadAnimation(this.f42647e, d.a.i0.a.a.swanapp_album_checkshake));
                d.a.i0.a.i1.d.d.e eVar = this.f42649g;
                if (eVar != null) {
                    eVar.a(d2);
                }
                notifyDataSetChanged();
                return;
            } else {
                d.a.i0.a.z1.b.f.e.f(this.f42647e, d.a.i0.a.h.swanapp_album_photo_too_big).F();
                return;
            }
        }
        d.a.i0.a.i1.d.c.e.h(mediaModel);
        jVar.f42671d.setImageResource(d.a.i0.a.e.swanapp_album_unselect_thumb_icon);
        jVar.f42670c.setVisibility(8);
        d.a.i0.a.i1.d.d.e eVar2 = this.f42649g;
        if (eVar2 != null) {
            eVar2.a(d2);
        }
        notifyDataSetChanged();
    }

    public final void m() {
        if (d.a.i0.a.i1.d.c.e.d() >= d.a.i0.a.i1.d.c.d.f42695c) {
            d.a.i0.a.i1.d.c.d.j(d.a.i0.a.i1.d.c.d.f42696d);
        } else {
            q(this.f42647e);
        }
    }

    public final boolean n(long j2) {
        if (j2 < 3000) {
            d.a.i0.a.z1.b.f.e.g(AppRuntime.getAppContext(), this.f42647e.getString(d.a.i0.a.h.swanapp_album_video_duration_min)).F();
            return true;
        } else if (j2 > 300000) {
            d.a.i0.a.z1.b.f.e.g(AppRuntime.getAppContext(), this.f42647e.getString(d.a.i0.a.h.swanapp_album_video_duration_max)).F();
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
            return this.f42647e.getString(d.a.i0.a.h.swanapp_video_duration, new Object[]{format, format2});
        }
        return this.f42647e.getString(d.a.i0.a.h.swanapp_video_duration_hour, new Object[]{String.format(Locale.getDefault(), "%02d", Long.valueOf(j4)), format, format2});
    }

    public final void p(Context context) {
        d.a.i0.a.s1.e.e(PermissionRequest.RESOURCE_VIDEO_CAPTURE, new String[]{PermissionRequest.RESOURCE_VIDEO_CAPTURE}, 1, context, new e());
    }

    public final void q(Context context) {
        d.a.i0.a.s1.e.e(PermissionRequest.RESOURCE_VIDEO_CAPTURE, new String[]{PermissionRequest.RESOURCE_VIDEO_CAPTURE}, 1, context, new c());
    }

    public final void r(View view) {
        view.findViewById(d.a.i0.a.f.album_camera_enter).setLayoutParams(this.j);
        view.setTag(null);
        view.setClickable(true);
        ImageView imageView = (ImageView) view.findViewById(d.a.i0.a.f.album_camera_icon);
        if (TextUtils.equals(d.a.i0.a.i1.d.c.d.f42694b, "Image")) {
            imageView.setImageResource(d.a.i0.a.e.swanapp_album_camera_item_selector);
            view.setOnClickListener(new View$OnClickListenerC0699a());
            return;
        }
        imageView.setImageResource(d.a.i0.a.e.swanapp_album_camera_video_selector);
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
                if (d.a.i0.a.i1.d.c.c.f42689a) {
                    e.printStackTrace();
                }
                str2 = "";
                mediaMetadataRetriever = mediaMetadataRetriever2;
                if (mediaMetadataRetriever != null) {
                }
                if (TextUtils.isEmpty(str2)) {
                }
                d.a.i0.a.z1.b.f.e.g(AppRuntime.getAppContext(), this.f42647e.getString(d.a.i0.a.h.swanapp_album_video_format)).F();
                return false;
            }
        } catch (Exception e3) {
            e = e3;
        }
        if (mediaMetadataRetriever != null) {
            try {
                mediaMetadataRetriever.close();
            } catch (Exception e4) {
                if (d.a.i0.a.i1.d.c.c.f42689a) {
                    e4.printStackTrace();
                }
            }
        }
        if (TextUtils.isEmpty(str2) && str2.startsWith(FileUtils.VIDEO_FILE_START)) {
            return TextUtils.equals("video/mp4", str2) || TextUtils.equals("video/3gp", str2) || TextUtils.equals("video/webm", str2) || TextUtils.equals("video/mkv", str2);
        }
        d.a.i0.a.z1.b.f.e.g(AppRuntime.getAppContext(), this.f42647e.getString(d.a.i0.a.h.swanapp_album_video_format)).F();
        return false;
    }

    public final void t() {
        d.a.i0.a.i1.d.c.b.e(this.f42647e, d.a.i0.a.i1.d.c.d.f42698f, d.a.i0.a.i1.d.c.d.f42699g, d.a.i0.a.i1.d.c.d.f42701i, new f());
    }

    public final void u() {
        d.a.i0.a.i1.d.c.b.f(this.f42647e, d.a.i0.a.i1.d.c.d.f42698f, new d());
    }

    public final void v(MediaModel mediaModel, j jVar, int i2) {
        if (d.a.i0.a.i1.d.c.e.f(mediaModel)) {
            jVar.f42671d.setImageResource(d.a.i0.a.e.swanapp_album_select_icon_bg);
            jVar.f42670c.setVisibility(0);
            jVar.f42670c.setText(String.valueOf(d.a.i0.a.i1.d.c.e.c(mediaModel) + 1));
        }
        if (d.a.i0.a.i1.d.c.d.f(d.a.i0.a.i1.d.c.d.f42696d, mediaModel)) {
            jVar.f42669b.setVisibility(0);
        } else {
            jVar.f42669b.setVisibility(8);
        }
        if (!d.a.i0.a.i1.d.c.c.f42692d) {
            jVar.f42675h.setVisibility(8);
        } else if (d.a.i0.a.i1.d.c.d.d(mediaModel.b())) {
            jVar.f42674g.setText(this.f42647e.getString(d.a.i0.a.h.swanapp_album_gif_photo));
        } else if (d.a.i0.a.i1.d.c.d.e(mediaModel.b())) {
            jVar.f42674g.setText(this.f42647e.getString(d.a.i0.a.h.swanapp_album_large_photo));
        } else {
            jVar.f42675h.setVisibility(8);
        }
        jVar.f42673f.setOnClickListener(new g(mediaModel, jVar));
        jVar.f42668a.setOnClickListener(new h(mediaModel, i2));
    }

    public final void w(MediaModel mediaModel, j jVar, int i2) {
        if (mediaModel instanceof VideoModel) {
            VideoModel videoModel = (VideoModel) mediaModel;
            jVar.f42675h.setVisibility(0);
            FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) jVar.f42675h.getLayoutParams();
            if ((videoModel.j() / 3600) / 1000 > 0) {
                layoutParams.width = this.f42647e.getResources().getDimensionPixelSize(d.a.i0.a.d.swanapp_album_item_longtime_width);
            } else {
                layoutParams.width = this.f42647e.getResources().getDimensionPixelSize(d.a.i0.a.d.swanapp_album_item_time_width);
            }
            layoutParams.height = this.f42647e.getResources().getDimensionPixelSize(d.a.i0.a.d.swanapp_album_item_time_height);
            jVar.f42675h.setLayoutParams(layoutParams);
            jVar.f42674g.setText(o(videoModel.j()));
            jVar.f42668a.setOnClickListener(new i(videoModel, mediaModel, i2));
        }
    }

    public void x(ArrayList<MediaModel> arrayList) {
        if (this.f42648f.size() > 0) {
            this.f42648f.clear();
        }
        this.f42648f.addAll(arrayList);
        d.a.i0.a.i1.d.c.d.i(this.f42648f);
        notifyDataSetChanged();
    }

    public final void y(String str, j jVar) {
        ImageRequestBuilder newBuilderWithSource = ImageRequestBuilder.newBuilderWithSource(Uri.fromFile(new File(str)));
        newBuilderWithSource.setResizeOptions(new ResizeOptions((int) (this.f42650h / 2.0f), (int) (this.f42651i / 2.0f)));
        newBuilderWithSource.setLocalThumbnailPreviewsEnabled(true);
        newBuilderWithSource.setImageDecodeOptions(ImageDecodeOptions.newBuilder().setForceStaticImage(true).build());
        AbstractDraweeController build = Fresco.newDraweeControllerBuilder().setImageRequest(newBuilderWithSource.build()).setAutoPlayAnimations(false).setOldController(jVar.f42668a.getController()).build();
        jVar.f42668a.setController(build);
        DraweeHierarchy hierarchy = build.getHierarchy();
        if (hierarchy instanceof GenericDraweeHierarchy) {
            d.a.i0.a.c1.a.y().c((GenericDraweeHierarchy) hierarchy, false);
        }
    }

    public void z(d.a.i0.a.i1.d.d.e eVar) {
        this.f42649g = eVar;
    }
}
