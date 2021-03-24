package d.b.g0.a.b1.d.b;

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
import d.b.g0.a.e;
import d.b.g0.a.f;
import d.b.g0.a.g;
import d.b.g0.a.h;
import d.b.g0.a.i2.h0;
import java.io.File;
import java.util.ArrayList;
/* loaded from: classes3.dex */
public class b extends BaseAdapter {

    /* renamed from: e  reason: collision with root package name */
    public Activity f43412e;

    /* renamed from: f  reason: collision with root package name */
    public String f43413f;

    /* renamed from: g  reason: collision with root package name */
    public ArrayList<d.b.g0.a.b1.d.e.a> f43414g;

    /* renamed from: h  reason: collision with root package name */
    public int f43415h;

    /* loaded from: classes3.dex */
    public class a {

        /* renamed from: a  reason: collision with root package name */
        public SimpleDraweeView f43416a;

        /* renamed from: b  reason: collision with root package name */
        public TextView f43417b;

        /* renamed from: c  reason: collision with root package name */
        public TextView f43418c;

        public a(b bVar, View view) {
            this.f43416a = (SimpleDraweeView) view.findViewById(f.album_name_item_img);
            this.f43417b = (TextView) view.findViewById(f.album_name_item_title);
            this.f43418c = (TextView) view.findViewById(f.album_name_item_number);
        }
    }

    public b(Activity activity, String str, ArrayList<d.b.g0.a.b1.d.e.a> arrayList) {
        this.f43412e = activity;
        this.f43413f = str;
        this.f43414g = arrayList;
        this.f43415h = (int) (h0.e(activity, 50.0f) / 2.0f);
    }

    public final String a(int i) {
        return TextUtils.equals(this.f43413f, "Image") ? this.f43412e.getString(h.swanapp_image_pages, new Object[]{Integer.valueOf(i)}) : this.f43412e.getString(h.swanapp_album_pages, new Object[]{Integer.valueOf(i)});
    }

    @Override // android.widget.Adapter
    public int getCount() {
        ArrayList<d.b.g0.a.b1.d.e.a> arrayList = this.f43414g;
        if (arrayList == null) {
            return 0;
        }
        return arrayList.size();
    }

    @Override // android.widget.Adapter
    public Object getItem(int i) {
        if (i < 0 || i > this.f43414g.size()) {
            return null;
        }
        return this.f43414g.get(i);
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        return i;
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        a aVar;
        if (view == null) {
            view = LayoutInflater.from(this.f43412e).inflate(g.swanapp_album_name_item, (ViewGroup) null);
            aVar = new a(this, view);
            view.setTag(aVar);
        } else {
            aVar = (a) view.getTag();
        }
        view.setBackground(this.f43412e.getResources().getDrawable(e.swanapp_album_name_item_selector));
        d.b.g0.a.b1.d.e.a aVar2 = this.f43414g.get(i);
        if (aVar2 == null) {
            return view;
        }
        aVar.f43417b.setText(aVar2.c());
        ArrayList<MediaModel> arrayList = aVar2.f43448h;
        if (arrayList == null) {
            return view;
        }
        aVar.f43418c.setText(a(arrayList.size()));
        if (aVar2.f43448h.get(0) != null && !TextUtils.isEmpty(aVar2.f43448h.get(0).b())) {
            ImageRequestBuilder newBuilderWithSource = ImageRequestBuilder.newBuilderWithSource(Uri.fromFile(new File(aVar2.f43448h.get(0).b())));
            int i2 = this.f43415h;
            newBuilderWithSource.setResizeOptions(new ResizeOptions(i2, i2));
            newBuilderWithSource.setLocalThumbnailPreviewsEnabled(true);
            aVar.f43416a.setController(Fresco.newDraweeControllerBuilder().setAutoPlayAnimations(false).setImageRequest(newBuilderWithSource.build()).setOldController(aVar.f43416a.getController()).build());
        }
        return view;
    }
}
