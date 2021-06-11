package d.a.l0.a.i1.d.b;

import android.app.Activity;
import android.net.Uri;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;
import com.baidu.swan.apps.media.chooser.model.MediaModel;
import com.facebook.drawee.backends.pipeline.Fresco;
import com.facebook.drawee.view.SimpleDraweeView;
import com.facebook.imagepipeline.common.ResizeOptions;
import com.facebook.imagepipeline.request.ImageRequestBuilder;
import d.a.l0.a.e;
import d.a.l0.a.f;
import d.a.l0.a.g;
import d.a.l0.a.h;
import d.a.l0.a.v2.n0;
import java.io.File;
import java.util.ArrayList;
/* loaded from: classes3.dex */
public class b extends BaseAdapter {

    /* renamed from: e  reason: collision with root package name */
    public Activity f46526e;

    /* renamed from: f  reason: collision with root package name */
    public String f46527f;

    /* renamed from: g  reason: collision with root package name */
    public ArrayList<d.a.l0.a.i1.d.f.a> f46528g;

    /* renamed from: h  reason: collision with root package name */
    public int f46529h;

    /* loaded from: classes3.dex */
    public class a {

        /* renamed from: a  reason: collision with root package name */
        public SimpleDraweeView f46530a;

        /* renamed from: b  reason: collision with root package name */
        public TextView f46531b;

        /* renamed from: c  reason: collision with root package name */
        public TextView f46532c;

        public a(b bVar, View view) {
            this.f46530a = (SimpleDraweeView) view.findViewById(f.album_name_item_img);
            this.f46531b = (TextView) view.findViewById(f.album_name_item_title);
            this.f46532c = (TextView) view.findViewById(f.album_name_item_number);
        }
    }

    public b(Activity activity, String str, ArrayList<d.a.l0.a.i1.d.f.a> arrayList) {
        this.f46526e = activity;
        this.f46527f = str;
        this.f46528g = arrayList;
        this.f46529h = (int) (n0.f(activity, 50.0f) / 2.0f);
    }

    public final String a(int i2) {
        return TextUtils.equals(this.f46527f, "Image") ? this.f46526e.getString(h.swanapp_image_pages, new Object[]{Integer.valueOf(i2)}) : this.f46526e.getString(h.swanapp_album_pages, new Object[]{Integer.valueOf(i2)});
    }

    @Override // android.widget.Adapter
    public int getCount() {
        ArrayList<d.a.l0.a.i1.d.f.a> arrayList = this.f46528g;
        if (arrayList == null) {
            return 0;
        }
        return arrayList.size();
    }

    @Override // android.widget.Adapter
    public Object getItem(int i2) {
        if (i2 < 0 || i2 > this.f46528g.size()) {
            return null;
        }
        return this.f46528g.get(i2);
    }

    @Override // android.widget.Adapter
    public long getItemId(int i2) {
        return i2;
    }

    @Override // android.widget.Adapter
    public View getView(int i2, View view, ViewGroup viewGroup) {
        a aVar;
        if (view == null) {
            view = LayoutInflater.from(this.f46526e).inflate(g.swanapp_album_name_item, (ViewGroup) null);
            aVar = new a(this, view);
            view.setTag(aVar);
        } else {
            aVar = (a) view.getTag();
        }
        view.setBackground(this.f46526e.getResources().getDrawable(e.swanapp_album_name_item_selector));
        d.a.l0.a.i1.d.f.a aVar2 = this.f46528g.get(i2);
        if (aVar2 == null) {
            return view;
        }
        aVar.f46531b.setText(aVar2.c());
        ArrayList<MediaModel> arrayList = aVar2.f46567h;
        if (arrayList == null) {
            return view;
        }
        aVar.f46532c.setText(a(arrayList.size()));
        if (aVar2.f46567h.get(0) != null && !TextUtils.isEmpty(aVar2.f46567h.get(0).b())) {
            ImageRequestBuilder newBuilderWithSource = ImageRequestBuilder.newBuilderWithSource(Uri.fromFile(new File(aVar2.f46567h.get(0).b())));
            int i3 = this.f46529h;
            newBuilderWithSource.setResizeOptions(new ResizeOptions(i3, i3));
            newBuilderWithSource.setLocalThumbnailPreviewsEnabled(true);
            aVar.f46530a.setController(Fresco.newDraweeControllerBuilder().setAutoPlayAnimations(false).setImageRequest(newBuilderWithSource.build()).setOldController(aVar.f46530a.getController()).build());
        }
        return view;
    }
}
