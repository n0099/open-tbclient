package d.b.i0.l0;

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
    public List<CollectEmotionData> f56503e = new ArrayList();

    /* renamed from: f  reason: collision with root package name */
    public List<CollectEmotionData> f56504f = new ArrayList();

    /* renamed from: g  reason: collision with root package name */
    public int f56505g = d.b.b.e.p.l.k(TbadkCoreApplication.getInst()) / 4;

    /* renamed from: h  reason: collision with root package name */
    public d.b.h0.b0.b f56506h = new d.b.h0.b0.b();
    public boolean i;
    public int j;
    public e k;
    public InterfaceC1327d l;

    /* loaded from: classes4.dex */
    public class a implements d.b.h0.a0.b {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ ViewGroup f56507e;

        public a(d dVar, ViewGroup viewGroup) {
            this.f56507e = viewGroup;
        }

        @Override // d.b.h0.a0.b
        public void a(d.b.b.j.d.a aVar, String str, boolean z) {
            TbImageView tbImageView = (TbImageView) this.f56507e.findViewWithTag(str);
            if (tbImageView == null || aVar == null) {
                return;
            }
            tbImageView.invalidate();
        }
    }

    /* loaded from: classes4.dex */
    public class b implements View.OnClickListener {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ int f56508e;

        public b(int i) {
            this.f56508e = i;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            CollectEmotionData item;
            ImageView imageView;
            if (d.this.i && (item = d.this.getItem(this.f56508e)) != null) {
                if (!d.this.f56504f.contains(item)) {
                    item.selectIndex = d.this.f56504f.size() + 1;
                    item.isSelect = true;
                    d.this.f56504f.add(item);
                } else {
                    item.selectIndex = -1;
                    int i = 0;
                    item.isSelect = false;
                    d.this.f56504f.remove(item);
                    while (i < d.this.f56504f.size()) {
                        i++;
                        d.this.getItem(this.f56508e).selectIndex = i;
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
                    d.this.k.c(d.this.f56504f);
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
                d.this.l.d();
            }
        }
    }

    /* renamed from: d.b.i0.l0.d$d  reason: collision with other inner class name */
    /* loaded from: classes4.dex */
    public interface InterfaceC1327d {
        void d();
    }

    /* loaded from: classes4.dex */
    public interface e {
        void c(List<CollectEmotionData> list);
    }

    /* loaded from: classes4.dex */
    public class f {

        /* renamed from: a  reason: collision with root package name */
        public View f56511a;

        /* renamed from: b  reason: collision with root package name */
        public TbImageView f56512b;

        /* renamed from: c  reason: collision with root package name */
        public ImageView f56513c;

        public f(d dVar) {
        }

        public /* synthetic */ f(d dVar, a aVar) {
            this(dVar);
        }
    }

    public d(InterfaceC1327d interfaceC1327d) {
        this.l = interfaceC1327d;
    }

    public void e() {
        if (this.i) {
            for (CollectEmotionData collectEmotionData : this.f56504f) {
                collectEmotionData.isSelect = false;
                collectEmotionData.selectIndex = -1;
            }
            this.f56504f.clear();
            ArrayList arrayList = new ArrayList(this.f56503e);
            this.f56503e.clear();
            this.f56503e.addAll(arrayList);
            notifyDataSetChanged();
            e eVar = this.k;
            if (eVar != null) {
                eVar.c(this.f56504f);
            }
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.widget.Adapter
    /* renamed from: f */
    public CollectEmotionData getItem(int i) {
        if (i == 0) {
            return null;
        }
        return (CollectEmotionData) ListUtils.getItem(this.f56503e, i - 1);
    }

    public List<CollectEmotionData> g() {
        return this.f56504f;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        return this.f56503e.size() + 1;
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        return i;
    }

    @Override // android.widget.BaseAdapter, android.widget.Adapter
    public int getItemViewType(int i) {
        return i == 0 ? 0 : 1;
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        f fVar;
        View view2;
        f fVar2;
        int itemViewType = getItemViewType(i);
        if (itemViewType == 0) {
            if (view == null) {
                fVar = new f(this, null);
                view = LayoutInflater.from(TbadkCoreApplication.getInst()).inflate(R.layout.collect_image_item_view, viewGroup, false);
                fVar.f56511a = view;
                ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
                layoutParams.height = this.f56505g;
                fVar.f56511a.setLayoutParams(layoutParams);
                TbImageView tbImageView = (TbImageView) view.findViewById(R.id.collect_pic);
                fVar.f56512b = tbImageView;
                ((RelativeLayout.LayoutParams) tbImageView.getLayoutParams()).setMargins(0, 0, 0, 0);
                fVar.f56512b.setScaleType(ImageView.ScaleType.CENTER);
                view.findViewById(R.id.collect_select_icon).setVisibility(8);
                view.setTag(fVar);
                SkinManager.setBackgroundColor(view, R.color.white_alpha0, this.j);
            } else {
                fVar = (f) view.getTag();
            }
            if (this.i) {
                fVar.f56511a.setEnabled(false);
                SkinManager.setImageResource(fVar.f56512b, R.drawable.icon_emotion_unplusadd_n);
            } else {
                fVar.f56511a.setEnabled(true);
                SkinManager.setImageResource(fVar.f56512b, R.drawable.icon_emotion_plusadd_n);
            }
            fVar.f56511a.setOnClickListener(new c());
            return view;
        } else if (itemViewType != 1) {
            return view;
        } else {
            if (view == null) {
                fVar2 = new f(this, null);
                view2 = LayoutInflater.from(TbadkCoreApplication.getInst()).inflate(R.layout.collect_image_item_view, viewGroup, false);
                fVar2.f56511a = view2;
                ViewGroup.LayoutParams layoutParams2 = view2.getLayoutParams();
                layoutParams2.height = this.f56505g;
                fVar2.f56511a.setLayoutParams(layoutParams2);
                fVar2.f56512b = (TbImageView) view2.findViewById(R.id.collect_pic);
                fVar2.f56513c = (ImageView) view2.findViewById(R.id.collect_select_icon);
                view2.setTag(fVar2);
                SkinManager.setBackgroundColor(view2, R.color.CAM_X0201, this.j);
            } else {
                view2 = view;
                fVar2 = (f) view.getTag();
            }
            fVar2.f56512b.setTag(null);
            fVar2.f56512b.setDefaultResource(R.drawable.img_default_100);
            fVar2.f56512b.W(null, 12, false);
            fVar2.f56512b.invalidate();
            SkinManager.setBackgroundResource(fVar2.f56512b, R.drawable.btn_choose_face_selector, this.j);
            ImageFileInfo imageFileInfo = getItem(i).imageFileInfo;
            if (imageFileInfo != null) {
                imageFileInfo.clearPageActions();
                int i2 = this.f56505g;
                imageFileInfo.addPageAction(d.b.h0.b0.g.d.g(i2, i2));
                fVar2.f56512b.setTag(imageFileInfo.toCachedKey(false));
                if (this.f56506h.c(imageFileInfo, false) != null) {
                    fVar2.f56512b.invalidate();
                } else {
                    this.f56506h.e(imageFileInfo, new a(this, viewGroup), false, false);
                }
            }
            if (this.i) {
                fVar2.f56513c.setVisibility(0);
            } else {
                fVar2.f56513c.setVisibility(8);
            }
            if (this.f56504f.contains(getItem(i))) {
                SkinManager.setBackgroundResource(fVar2.f56513c, R.drawable.ic_post_image_selected_s);
            } else {
                SkinManager.setBackgroundResource(fVar2.f56513c, R.drawable.ic_post_image_selected_n);
            }
            b bVar = new b(i);
            fVar2.f56512b.setOnClickListener(bVar);
            fVar2.f56513c.setOnClickListener(bVar);
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
        this.f56503e.clear();
        if (list == null) {
            return;
        }
        this.f56503e.addAll(list);
        notifyDataSetChanged();
    }

    public void j(boolean z) {
        if (this.i == z) {
            return;
        }
        for (CollectEmotionData collectEmotionData : this.f56504f) {
            collectEmotionData.isSelect = false;
            collectEmotionData.selectIndex = -1;
        }
        this.f56504f.clear();
        this.i = z;
        ArrayList arrayList = new ArrayList(this.f56503e);
        this.f56503e.clear();
        this.f56503e.addAll(arrayList);
        notifyDataSetChanged();
    }

    public void k(int i) {
        this.j = i;
    }
}
