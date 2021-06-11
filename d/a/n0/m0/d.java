package d.a.n0.m0;

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
    public List<CollectEmotionData> f60914e = new ArrayList();

    /* renamed from: f  reason: collision with root package name */
    public List<CollectEmotionData> f60915f = new ArrayList();

    /* renamed from: g  reason: collision with root package name */
    public int f60916g = d.a.c.e.p.l.k(TbadkCoreApplication.getInst()) / 4;

    /* renamed from: h  reason: collision with root package name */
    public d.a.m0.b0.b f60917h = new d.a.m0.b0.b();

    /* renamed from: i  reason: collision with root package name */
    public boolean f60918i;
    public int j;
    public e k;
    public InterfaceC1488d l;

    /* loaded from: classes4.dex */
    public class a implements d.a.m0.a0.b {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ ViewGroup f60919e;

        public a(d dVar, ViewGroup viewGroup) {
            this.f60919e = viewGroup;
        }

        @Override // d.a.m0.a0.b
        public void a(d.a.c.k.d.a aVar, String str, boolean z) {
            TbImageView tbImageView = (TbImageView) this.f60919e.findViewWithTag(str);
            if (tbImageView == null || aVar == null) {
                return;
            }
            tbImageView.invalidate();
        }
    }

    /* loaded from: classes4.dex */
    public class b implements View.OnClickListener {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ int f60920e;

        public b(int i2) {
            this.f60920e = i2;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            CollectEmotionData item;
            ImageView imageView;
            if (d.this.f60918i && (item = d.this.getItem(this.f60920e)) != null) {
                if (!d.this.f60915f.contains(item)) {
                    item.selectIndex = d.this.f60915f.size() + 1;
                    item.isSelect = true;
                    d.this.f60915f.add(item);
                } else {
                    item.selectIndex = -1;
                    int i2 = 0;
                    item.isSelect = false;
                    d.this.f60915f.remove(item);
                    while (i2 < d.this.f60915f.size()) {
                        i2++;
                        d.this.getItem(this.f60920e).selectIndex = i2;
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
                    d.this.k.b(d.this.f60915f);
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

    /* renamed from: d.a.n0.m0.d$d  reason: collision with other inner class name */
    /* loaded from: classes4.dex */
    public interface InterfaceC1488d {
        void e();
    }

    /* loaded from: classes4.dex */
    public interface e {
        void b(List<CollectEmotionData> list);
    }

    /* loaded from: classes4.dex */
    public class f {

        /* renamed from: a  reason: collision with root package name */
        public View f60923a;

        /* renamed from: b  reason: collision with root package name */
        public TbImageView f60924b;

        /* renamed from: c  reason: collision with root package name */
        public ImageView f60925c;

        public f(d dVar) {
        }

        public /* synthetic */ f(d dVar, a aVar) {
            this(dVar);
        }
    }

    public d(InterfaceC1488d interfaceC1488d) {
        this.l = interfaceC1488d;
    }

    public void e() {
        if (this.f60918i) {
            for (CollectEmotionData collectEmotionData : this.f60915f) {
                collectEmotionData.isSelect = false;
                collectEmotionData.selectIndex = -1;
            }
            this.f60915f.clear();
            ArrayList arrayList = new ArrayList(this.f60914e);
            this.f60914e.clear();
            this.f60914e.addAll(arrayList);
            notifyDataSetChanged();
            e eVar = this.k;
            if (eVar != null) {
                eVar.b(this.f60915f);
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
        return (CollectEmotionData) ListUtils.getItem(this.f60914e, i2 - 1);
    }

    public List<CollectEmotionData> g() {
        return this.f60915f;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        return this.f60914e.size() + 1;
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
                fVar.f60923a = view;
                ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
                layoutParams.height = this.f60916g;
                fVar.f60923a.setLayoutParams(layoutParams);
                TbImageView tbImageView = (TbImageView) view.findViewById(R.id.collect_pic);
                fVar.f60924b = tbImageView;
                ((RelativeLayout.LayoutParams) tbImageView.getLayoutParams()).setMargins(0, 0, 0, 0);
                fVar.f60924b.setScaleType(ImageView.ScaleType.CENTER);
                view.findViewById(R.id.collect_select_icon).setVisibility(8);
                view.setTag(fVar);
                SkinManager.setBackgroundColor(view, R.color.white_alpha0, this.j);
            } else {
                fVar = (f) view.getTag();
            }
            if (this.f60918i) {
                fVar.f60923a.setEnabled(false);
                SkinManager.setImageResource(fVar.f60924b, R.drawable.icon_emotion_unplusadd_n);
            } else {
                fVar.f60923a.setEnabled(true);
                SkinManager.setImageResource(fVar.f60924b, R.drawable.icon_emotion_plusadd_n);
            }
            fVar.f60923a.setOnClickListener(new c());
            return view;
        } else if (itemViewType != 1) {
            return view;
        } else {
            if (view == null) {
                fVar2 = new f(this, null);
                view2 = LayoutInflater.from(TbadkCoreApplication.getInst()).inflate(R.layout.collect_image_item_view, viewGroup, false);
                fVar2.f60923a = view2;
                ViewGroup.LayoutParams layoutParams2 = view2.getLayoutParams();
                layoutParams2.height = this.f60916g;
                fVar2.f60923a.setLayoutParams(layoutParams2);
                fVar2.f60924b = (TbImageView) view2.findViewById(R.id.collect_pic);
                fVar2.f60925c = (ImageView) view2.findViewById(R.id.collect_select_icon);
                view2.setTag(fVar2);
                SkinManager.setBackgroundColor(view2, R.color.CAM_X0201, this.j);
            } else {
                view2 = view;
                fVar2 = (f) view.getTag();
            }
            fVar2.f60924b.setTag(null);
            fVar2.f60924b.setDefaultResource(R.drawable.img_default_100);
            fVar2.f60924b.U(null, 12, false);
            fVar2.f60924b.invalidate();
            SkinManager.setBackgroundResource(fVar2.f60924b, R.drawable.btn_choose_face_selector, this.j);
            ImageFileInfo imageFileInfo = getItem(i2).imageFileInfo;
            if (imageFileInfo != null) {
                imageFileInfo.clearPageActions();
                int i3 = this.f60916g;
                imageFileInfo.addPageAction(d.a.m0.b0.g.d.g(i3, i3));
                fVar2.f60924b.setTag(imageFileInfo.toCachedKey(false));
                if (this.f60917h.c(imageFileInfo, false) != null) {
                    fVar2.f60924b.invalidate();
                } else {
                    this.f60917h.e(imageFileInfo, new a(this, viewGroup), false, false);
                }
            }
            if (this.f60918i) {
                fVar2.f60925c.setVisibility(0);
            } else {
                fVar2.f60925c.setVisibility(8);
            }
            if (this.f60915f.contains(getItem(i2))) {
                SkinManager.setBackgroundResource(fVar2.f60925c, R.drawable.ic_post_image_selected_s);
            } else {
                SkinManager.setBackgroundResource(fVar2.f60925c, R.drawable.ic_post_image_selected_n);
            }
            b bVar = new b(i2);
            fVar2.f60924b.setOnClickListener(bVar);
            fVar2.f60925c.setOnClickListener(bVar);
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
        this.f60914e.clear();
        if (list == null) {
            return;
        }
        this.f60914e.addAll(list);
        notifyDataSetChanged();
    }

    public void j(boolean z) {
        if (this.f60918i == z) {
            return;
        }
        for (CollectEmotionData collectEmotionData : this.f60915f) {
            collectEmotionData.isSelect = false;
            collectEmotionData.selectIndex = -1;
        }
        this.f60915f.clear();
        this.f60918i = z;
        ArrayList arrayList = new ArrayList(this.f60914e);
        this.f60914e.clear();
        this.f60914e.addAll(arrayList);
        notifyDataSetChanged();
    }

    public void k(int i2) {
        this.j = i2;
    }
}
