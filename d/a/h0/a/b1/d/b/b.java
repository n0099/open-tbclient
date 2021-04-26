package d.a.h0.a.b1.d.b;

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
import d.a.h0.a.e;
import d.a.h0.a.f;
import d.a.h0.a.g;
import d.a.h0.a.h;
import d.a.h0.a.i2.h0;
import java.io.File;
import java.util.ArrayList;
/* loaded from: classes3.dex */
public class b extends BaseAdapter {

    /* renamed from: e  reason: collision with root package name */
    public Activity f41409e;

    /* renamed from: f  reason: collision with root package name */
    public String f41410f;

    /* renamed from: g  reason: collision with root package name */
    public ArrayList<d.a.h0.a.b1.d.e.a> f41411g;

    /* renamed from: h  reason: collision with root package name */
    public int f41412h;

    /* loaded from: classes3.dex */
    public class a {

        /* renamed from: a  reason: collision with root package name */
        public SimpleDraweeView f41413a;

        /* renamed from: b  reason: collision with root package name */
        public TextView f41414b;

        /* renamed from: c  reason: collision with root package name */
        public TextView f41415c;

        public a(b bVar, View view) {
            this.f41413a = (SimpleDraweeView) view.findViewById(f.album_name_item_img);
            this.f41414b = (TextView) view.findViewById(f.album_name_item_title);
            this.f41415c = (TextView) view.findViewById(f.album_name_item_number);
        }
    }

    public b(Activity activity, String str, ArrayList<d.a.h0.a.b1.d.e.a> arrayList) {
        this.f41409e = activity;
        this.f41410f = str;
        this.f41411g = arrayList;
        this.f41412h = (int) (h0.e(activity, 50.0f) / 2.0f);
    }

    public final String a(int i2) {
        return TextUtils.equals(this.f41410f, "Image") ? this.f41409e.getString(h.swanapp_image_pages, new Object[]{Integer.valueOf(i2)}) : this.f41409e.getString(h.swanapp_album_pages, new Object[]{Integer.valueOf(i2)});
    }

    @Override // android.widget.Adapter
    public int getCount() {
        ArrayList<d.a.h0.a.b1.d.e.a> arrayList = this.f41411g;
        if (arrayList == null) {
            return 0;
        }
        return arrayList.size();
    }

    @Override // android.widget.Adapter
    public Object getItem(int i2) {
        if (i2 < 0 || i2 > this.f41411g.size()) {
            return null;
        }
        return this.f41411g.get(i2);
    }

    @Override // android.widget.Adapter
    public long getItemId(int i2) {
        return i2;
    }

    @Override // android.widget.Adapter
    public View getView(int i2, View view, ViewGroup viewGroup) {
        a aVar;
        if (view == null) {
            view = LayoutInflater.from(this.f41409e).inflate(g.swanapp_album_name_item, (ViewGroup) null);
            aVar = new a(this, view);
            view.setTag(aVar);
        } else {
            aVar = (a) view.getTag();
        }
        view.setBackground(this.f41409e.getResources().getDrawable(e.swanapp_album_name_item_selector));
        d.a.h0.a.b1.d.e.a aVar2 = this.f41411g.get(i2);
        if (aVar2 == null) {
            return view;
        }
        aVar.f41414b.setText(aVar2.c());
        ArrayList<MediaModel> arrayList = aVar2.f41446h;
        if (arrayList == null) {
            return view;
        }
        aVar.f41415c.setText(a(arrayList.size()));
        if (aVar2.f41446h.get(0) != null && !TextUtils.isEmpty(aVar2.f41446h.get(0).b())) {
            ImageRequestBuilder newBuilderWithSource = ImageRequestBuilder.newBuilderWithSource(Uri.fromFile(new File(aVar2.f41446h.get(0).b())));
            int i3 = this.f41412h;
            newBuilderWithSource.setResizeOptions(new ResizeOptions(i3, i3));
            newBuilderWithSource.setLocalThumbnailPreviewsEnabled(true);
            aVar.f41413a.setController(Fresco.newDraweeControllerBuilder().setAutoPlayAnimations(false).setImageRequest(newBuilderWithSource.build()).setOldController(aVar.f41413a.getController()).build());
        }
        return view;
    }
}
