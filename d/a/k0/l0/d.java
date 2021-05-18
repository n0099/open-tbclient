package d.a.k0.l0;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.img.ImageFileInfo;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
import com.baidu.tieba.faceshop.CollectEmotionData;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes4.dex */
public class d extends BaseAdapter {

    /* renamed from: e  reason: collision with root package name */
    public List<CollectEmotionData> f57035e = new ArrayList();

    /* renamed from: f  reason: collision with root package name */
    public List<CollectEmotionData> f57036f = new ArrayList();

    /* renamed from: g  reason: collision with root package name */
    public int f57037g = d.a.c.e.p.l.k(TbadkCoreApplication.getInst()) / 4;

    /* renamed from: h  reason: collision with root package name */
    public d.a.j0.b0.b f57038h = new d.a.j0.b0.b();

    /* renamed from: i  reason: collision with root package name */
    public boolean f57039i;
    public int j;
    public e k;
    public InterfaceC1414d l;

    /* loaded from: classes4.dex */
    public class a implements d.a.j0.a0.b {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ ViewGroup f57040e;

        public a(d dVar, ViewGroup viewGroup) {
            this.f57040e = viewGroup;
        }

        @Override // d.a.j0.a0.b
        public void a(d.a.c.j.d.a aVar, String str, boolean z) {
            TbImageView tbImageView = (TbImageView) this.f57040e.findViewWithTag(str);
            if (tbImageView == null || aVar == null) {
                return;
            }
            tbImageView.invalidate();
        }
    }

    /* loaded from: classes4.dex */
    public class b implements View.OnClickListener {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ int f57041e;

        public b(int i2) {
            this.f57041e = i2;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            CollectEmotionData item;
            ImageView imageView;
            if (d.this.f57039i && (item = d.this.getItem(this.f57041e)) != null) {
                if (!d.this.f57036f.contains(item)) {
                    item.selectIndex = d.this.f57036f.size() + 1;
                    item.isSelect = true;
                    d.this.f57036f.add(item);
                } else {
                    item.selectIndex = -1;
                    int i2 = 0;
                    item.isSelect = false;
                    d.this.f57036f.remove(item);
                    while (i2 < d.this.f57036f.size()) {
                        i2++;
                        d.this.getItem(this.f57041e).selectIndex = i2;
                    }
                }
                if (view.getId() == R.id.collect_select_icon) {
                    imageView = (ImageView) view;
                } else {
                    imageView = (ImageView) ((RelativeLayout) view.getParent()).findViewById(R.id.collect_select_icon);
                }
                if (imageView != null) {
                    if (item.isSelect) {
                        SkinManager.setBackgroundResource(imageView, R.drawable.ic_post_image_selected_s);
                    } else {
                        SkinManager.setBackgroundResource(imageView, R.drawable.ic_post_image_selected_n);
                    }
                }
                if (d.this.k != null) {
                    d.this.k.b(d.this.f57036f);
                }
            }
        }
    }

    /* loaded from: classes4.dex */
    public class c implements View.OnClickListener {
        public c() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (d.this.l != null) {
                d.this.l.e();
            }
        }
    }

    /* renamed from: d.a.k0.l0.d$d  reason: collision with other inner class name */
    /* loaded from: classes4.dex */
    public interface InterfaceC1414d {
        void e();
    }

    /* loaded from: classes4.dex */
    public interface e {
        void b(List<CollectEmotionData> list);
    }

    /* loaded from: classes4.dex */
    public class f {

        /* renamed from: a  reason: collision with root package name */
        public View f57044a;

        /* renamed from: b  reason: collision with root package name */
        public TbImageView f57045b;

        /* renamed from: c  reason: collision with root package name */
        public ImageView f57046c;

        public f(d dVar) {
        }

        public /* synthetic */ f(d dVar, a aVar) {
            this(dVar);
        }
    }

    public d(InterfaceC1414d interfaceC1414d) {
        this.l = interfaceC1414d;
    }

    public void e() {
        if (this.f57039i) {
            for (CollectEmotionData collectEmotionData : this.f57036f) {
                collectEmotionData.isSelect = false;
                collectEmotionData.selectIndex = -1;
            }
            this.f57036f.clear();
            ArrayList arrayList = new ArrayList(this.f57035e);
            this.f57035e.clear();
            this.f57035e.addAll(arrayList);
            notifyDataSetChanged();
            e eVar = this.k;
            if (eVar != null) {
                eVar.b(this.f57036f);
            }
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.widget.Adapter
    /* renamed from: f */
    public CollectEmotionData getItem(int i2) {
        if (i2 == 0) {
            return null;
        }
        return (CollectEmotionData) ListUtils.getItem(this.f57035e, i2 - 1);
    }

    public List<CollectEmotionData> g() {
        return this.f57036f;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        return this.f57035e.size() + 1;
    }

    @Override // android.widget.Adapter
    public long getItemId(int i2) {
        return i2;
    }

    @Override // android.widget.BaseAdapter, android.widget.Adapter
    public int getItemViewType(int i2) {
        return i2 == 0 ? 0 : 1;
    }

    @Override // android.widget.Adapter
    public View getView(int i2, View view, ViewGroup viewGroup) {
        f fVar;
        View view2;
        f fVar2;
        int itemViewType = getItemViewType(i2);
        if (itemViewType == 0) {
            if (view == null) {
                fVar = new f(this, null);
                view = LayoutInflater.from(TbadkCoreApplication.getInst()).inflate(R.layout.collect_image_item_view, viewGroup, false);
                fVar.f57044a = view;
                ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
                layoutParams.height = this.f57037g;
                fVar.f57044a.setLayoutParams(layoutParams);
                TbImageView tbImageView = (TbImageView) view.findViewById(R.id.collect_pic);
                fVar.f57045b = tbImageView;
                ((RelativeLayout.LayoutParams) tbImageView.getLayoutParams()).setMargins(0, 0, 0, 0);
                fVar.f57045b.setScaleType(ImageView.ScaleType.CENTER);
                view.findViewById(R.id.collect_select_icon).setVisibility(8);
                view.setTag(fVar);
                SkinManager.setBackgroundColor(view, R.color.white_alpha0, this.j);
            } else {
                fVar = (f) view.getTag();
            }
            if (this.f57039i) {
                fVar.f57044a.setEnabled(false);
                SkinManager.setImageResource(fVar.f57045b, R.drawable.icon_emotion_unplusadd_n);
            } else {
                fVar.f57044a.setEnabled(true);
                SkinManager.setImageResource(fVar.f57045b, R.drawable.icon_emotion_plusadd_n);
            }
            fVar.f57044a.setOnClickListener(new c());
            return view;
        } else if (itemViewType != 1) {
            return view;
        } else {
            if (view == null) {
                fVar2 = new f(this, null);
                view2 = LayoutInflater.from(TbadkCoreApplication.getInst()).inflate(R.layout.collect_image_item_view, viewGroup, false);
                fVar2.f57044a = view2;
                ViewGroup.LayoutParams layoutParams2 = view2.getLayoutParams();
                layoutParams2.height = this.f57037g;
                fVar2.f57044a.setLayoutParams(layoutParams2);
                fVar2.f57045b = (TbImageView) view2.findViewById(R.id.collect_pic);
                fVar2.f57046c = (ImageView) view2.findViewById(R.id.collect_select_icon);
                view2.setTag(fVar2);
                SkinManager.setBackgroundColor(view2, R.color.CAM_X0201, this.j);
            } else {
                view2 = view;
                fVar2 = (f) view.getTag();
            }
            fVar2.f57045b.setTag(null);
            fVar2.f57045b.setDefaultResource(R.drawable.img_default_100);
            fVar2.f57045b.V(null, 12, false);
            fVar2.f57045b.invalidate();
            SkinManager.setBackgroundResource(fVar2.f57045b, R.drawable.btn_choose_face_selector, this.j);
            ImageFileInfo imageFileInfo = getItem(i2).imageFileInfo;
            if (imageFileInfo != null) {
                imageFileInfo.clearPageActions();
                int i3 = this.f57037g;
                imageFileInfo.addPageAction(d.a.j0.b0.g.d.g(i3, i3));
                fVar2.f57045b.setTag(imageFileInfo.toCachedKey(false));
                if (this.f57038h.c(imageFileInfo, false) != null) {
                    fVar2.f57045b.invalidate();
                } else {
                    this.f57038h.e(imageFileInfo, new a(this, viewGroup), false, false);
                }
            }
            if (this.f57039i) {
                fVar2.f57046c.setVisibility(0);
            } else {
                fVar2.f57046c.setVisibility(8);
            }
            if (this.f57036f.contains(getItem(i2))) {
                SkinManager.setBackgroundResource(fVar2.f57046c, R.drawable.ic_post_image_selected_s);
            } else {
                SkinManager.setBackgroundResource(fVar2.f57046c, R.drawable.ic_post_image_selected_n);
            }
            b bVar = new b(i2);
            fVar2.f57045b.setOnClickListener(bVar);
            fVar2.f57046c.setOnClickListener(bVar);
            return view2;
        }
    }

    @Override // android.widget.BaseAdapter, android.widget.Adapter
    public int getViewTypeCount() {
        return 2;
    }

    public void h(e eVar) {
        this.k = eVar;
    }

    public void i(List<CollectEmotionData> list) {
        this.f57035e.clear();
        if (list == null) {
            return;
        }
        this.f57035e.addAll(list);
        notifyDataSetChanged();
    }

    public void j(boolean z) {
        if (this.f57039i == z) {
            return;
        }
        for (CollectEmotionData collectEmotionData : this.f57036f) {
            collectEmotionData.isSelect = false;
            collectEmotionData.selectIndex = -1;
        }
        this.f57036f.clear();
        this.f57039i = z;
        ArrayList arrayList = new ArrayList(this.f57035e);
        this.f57035e.clear();
        this.f57035e.addAll(arrayList);
        notifyDataSetChanged();
    }

    public void k(int i2) {
        this.j = i2;
    }
}
