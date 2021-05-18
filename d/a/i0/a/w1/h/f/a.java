package d.a.i0.a.w1.h.f;

import android.content.Context;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.core.content.ContextCompat;
import com.baidu.swan.apps.publisher.view.PhotoChooseView;
import com.facebook.drawee.backends.pipeline.Fresco;
import com.facebook.drawee.view.SimpleDraweeView;
import com.facebook.imagepipeline.common.ImageDecodeOptions;
import com.facebook.imagepipeline.common.ResizeOptions;
import com.facebook.imagepipeline.request.ImageRequestBuilder;
import d.a.i0.a.e;
import d.a.i0.a.f;
import d.a.i0.a.g;
import d.a.i0.a.h;
import d.a.i0.a.v2.h0;
import d.a.i0.a.v2.n0;
import d.a.i0.a.v2.o0;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes3.dex */
public class a extends BaseAdapter {

    /* renamed from: e  reason: collision with root package name */
    public int f45417e;

    /* renamed from: f  reason: collision with root package name */
    public int f45418f;

    /* renamed from: g  reason: collision with root package name */
    public int f45419g = 9;

    /* renamed from: h  reason: collision with root package name */
    public List<String> f45420h = new ArrayList(0);

    /* renamed from: i  reason: collision with root package name */
    public Context f45421i;
    public PhotoChooseView.b j;

    /* renamed from: d.a.i0.a.w1.h.f.a$a  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public class View$OnClickListenerC0882a implements View.OnClickListener {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ int f45422e;

        public View$OnClickListenerC0882a(int i2) {
            this.f45422e = i2;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            a.this.f45420h.remove(this.f45422e);
            a.this.notifyDataSetChanged();
            if (a.this.j != null) {
                a.this.j.a(a.this.f45420h.size());
            }
        }
    }

    /* loaded from: classes3.dex */
    public static class b {

        /* renamed from: a  reason: collision with root package name */
        public SimpleDraweeView f45424a;

        /* renamed from: b  reason: collision with root package name */
        public ImageView f45425b;

        /* renamed from: c  reason: collision with root package name */
        public RelativeLayout f45426c;

        /* renamed from: d  reason: collision with root package name */
        public TextView f45427d;
    }

    public a(Context context, int i2, int i3) {
        this.f45421i = context;
        this.f45417e = i2;
        this.f45418f = i3;
    }

    public List<String> c() {
        return this.f45420h;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.widget.Adapter
    /* renamed from: d */
    public String getItem(int i2) {
        return i2 < this.f45420h.size() ? this.f45420h.get(i2) : "more_option";
    }

    public boolean e(int i2) {
        return i2 == getCount() - 1 && this.f45420h.size() < this.f45419g;
    }

    public void f(List<String> list) {
        if (list != null) {
            for (String str : list) {
                if (!this.f45420h.contains(str)) {
                    this.f45420h.add(str);
                }
            }
        }
    }

    public void g(PhotoChooseView.b bVar) {
        this.j = bVar;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        int size = this.f45420h.size();
        int i2 = this.f45419g;
        return size < i2 ? size + 1 : i2;
    }

    @Override // android.widget.Adapter
    public long getItemId(int i2) {
        return i2;
    }

    @Override // android.widget.Adapter
    public View getView(int i2, View view, ViewGroup viewGroup) {
        View view2;
        b bVar;
        if (view == null) {
            bVar = new b();
            view2 = LayoutInflater.from(this.f45421i).inflate(g.swanapp_publisher_photo_choose_layout, viewGroup, false);
            bVar.f45424a = (SimpleDraweeView) view2.findViewById(f.publish_img);
            bVar.f45425b = (ImageView) view2.findViewById(f.publish_delete);
            bVar.f45426c = (RelativeLayout) view2.findViewById(f.publish_right_bottom_bg);
            bVar.f45427d = (TextView) view2.findViewById(f.publish_right_bottom_tip);
            bVar.f45424a.setScaleType(ImageView.ScaleType.CENTER_CROP);
            int o = n0.o(this.f45421i) - n0.g(30.0f);
            int i3 = this.f45417e;
            int i4 = this.f45418f;
            int i5 = (o - (i3 * (i4 - 1))) / i4;
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) bVar.f45424a.getLayoutParams();
            layoutParams.width = i5;
            layoutParams.height = i5;
            bVar.f45424a.setLayoutParams(layoutParams);
            bVar.f45424a.setBackground(ContextCompat.getDrawable(this.f45421i, e.swanapp_ugc_img_stroke_bg));
            view2.setTag(bVar);
        } else {
            view2 = view;
            bVar = (b) view.getTag();
        }
        int o2 = n0.o(this.f45421i) / 3;
        int o3 = n0.o(this.f45421i) / 3;
        bVar.f45425b.setImageResource(e.swanapp_ugc_delete_selected_img);
        bVar.f45425b.setVisibility(8);
        if (e(i2)) {
            bVar.f45426c.setVisibility(8);
            bVar.f45424a.setBackground(ContextCompat.getDrawable(this.f45421i, e.swanapp_ugc_add_photo_stroke_bg));
            bVar.f45424a.setImageResource(e.swanapp_ugc_add_localalbum_selector);
        } else {
            bVar.f45425b.setVisibility(0);
            String item = getItem(i2);
            if (!TextUtils.isEmpty(item)) {
                if (h0.c(item)) {
                    bVar.f45426c.setVisibility(0);
                    bVar.f45427d.setText(this.f45421i.getString(h.swanapp_album_gif_photo));
                } else if (h0.f(item)) {
                    bVar.f45426c.setVisibility(0);
                    bVar.f45427d.setText(this.f45421i.getString(h.swanapp_album_large_photo));
                } else {
                    bVar.f45426c.setVisibility(8);
                }
                Fresco.getImagePipeline().evictFromCache(o0.p(item));
                bVar.f45424a.setController(Fresco.newDraweeControllerBuilder().setAutoPlayAnimations(false).setOldController(bVar.f45424a.getController()).setImageRequest(ImageRequestBuilder.newBuilderWithSource(o0.p(item)).setResizeOptions(new ResizeOptions((int) (o2 / 2.0f), (int) (o3 / 2.0f))).setImageDecodeOptions(ImageDecodeOptions.newBuilder().setForceStaticImage(true).build()).build()).build());
            }
        }
        bVar.f45425b.setOnClickListener(new View$OnClickListenerC0882a(i2));
        return view2;
    }

    public void h(int i2) {
        this.f45419g = i2;
    }
}
