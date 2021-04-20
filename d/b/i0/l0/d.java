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
    public List<CollectEmotionData> f57909e = new ArrayList();

    /* renamed from: f  reason: collision with root package name */
    public List<CollectEmotionData> f57910f = new ArrayList();

    /* renamed from: g  reason: collision with root package name */
    public int f57911g = d.b.c.e.p.l.k(TbadkCoreApplication.getInst()) / 4;

    /* renamed from: h  reason: collision with root package name */
    public d.b.h0.b0.b f57912h = new d.b.h0.b0.b();
    public boolean i;
    public int j;
    public e k;
    public InterfaceC1380d l;

    /* loaded from: classes4.dex */
    public class a implements d.b.h0.a0.b {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ ViewGroup f57913e;

        public a(d dVar, ViewGroup viewGroup) {
            this.f57913e = viewGroup;
        }

        @Override // d.b.h0.a0.b
        public void a(d.b.c.j.d.a aVar, String str, boolean z) {
            TbImageView tbImageView = (TbImageView) this.f57913e.findViewWithTag(str);
            if (tbImageView == null || aVar == null) {
                return;
            }
            tbImageView.invalidate();
        }
    }

    /* loaded from: classes4.dex */
    public class b implements View.OnClickListener {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ int f57914e;

        public b(int i) {
            this.f57914e = i;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            CollectEmotionData item;
            ImageView imageView;
            if (d.this.i && (item = d.this.getItem(this.f57914e)) != null) {
                if (!d.this.f57910f.contains(item)) {
                    item.selectIndex = d.this.f57910f.size() + 1;
                    item.isSelect = true;
                    d.this.f57910f.add(item);
                } else {
                    item.selectIndex = -1;
                    int i = 0;
                    item.isSelect = false;
                    d.this.f57910f.remove(item);
                    while (i < d.this.f57910f.size()) {
                        i++;
                        d.this.getItem(this.f57914e).selectIndex = i;
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
                    d.this.k.c(d.this.f57910f);
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
    public interface InterfaceC1380d {
        void d();
    }

    /* loaded from: classes4.dex */
    public interface e {
        void c(List<CollectEmotionData> list);
    }

    /* loaded from: classes4.dex */
    public class f {

        /* renamed from: a  reason: collision with root package name */
        public View f57917a;

        /* renamed from: b  reason: collision with root package name */
        public TbImageView f57918b;

        /* renamed from: c  reason: collision with root package name */
        public ImageView f57919c;

        public f(d dVar) {
        }

        public /* synthetic */ f(d dVar, a aVar) {
            this(dVar);
        }
    }

    public d(InterfaceC1380d interfaceC1380d) {
        this.l = interfaceC1380d;
    }

    public void e() {
        if (this.i) {
            for (CollectEmotionData collectEmotionData : this.f57910f) {
                collectEmotionData.isSelect = false;
                collectEmotionData.selectIndex = -1;
            }
            this.f57910f.clear();
            ArrayList arrayList = new ArrayList(this.f57909e);
            this.f57909e.clear();
            this.f57909e.addAll(arrayList);
            notifyDataSetChanged();
            e eVar = this.k;
            if (eVar != null) {
                eVar.c(this.f57910f);
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
        return (CollectEmotionData) ListUtils.getItem(this.f57909e, i - 1);
    }

    public List<CollectEmotionData> g() {
        return this.f57910f;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        return this.f57909e.size() + 1;
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
                fVar.f57917a = view;
                ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
                layoutParams.height = this.f57911g;
                fVar.f57917a.setLayoutParams(layoutParams);
                TbImageView tbImageView = (TbImageView) view.findViewById(R.id.collect_pic);
                fVar.f57918b = tbImageView;
                ((RelativeLayout.LayoutParams) tbImageView.getLayoutParams()).setMargins(0, 0, 0, 0);
                fVar.f57918b.setScaleType(ImageView.ScaleType.CENTER);
                view.findViewById(R.id.collect_select_icon).setVisibility(8);
                view.setTag(fVar);
                SkinManager.setBackgroundColor(view, R.color.white_alpha0, this.j);
            } else {
                fVar = (f) view.getTag();
            }
            if (this.i) {
                fVar.f57917a.setEnabled(false);
                SkinManager.setImageResource(fVar.f57918b, R.drawable.icon_emotion_unplusadd_n);
            } else {
                fVar.f57917a.setEnabled(true);
                SkinManager.setImageResource(fVar.f57918b, R.drawable.icon_emotion_plusadd_n);
            }
            fVar.f57917a.setOnClickListener(new c());
            return view;
        } else if (itemViewType != 1) {
            return view;
        } else {
            if (view == null) {
                fVar2 = new f(this, null);
                view2 = LayoutInflater.from(TbadkCoreApplication.getInst()).inflate(R.layout.collect_image_item_view, viewGroup, false);
                fVar2.f57917a = view2;
                ViewGroup.LayoutParams layoutParams2 = view2.getLayoutParams();
                layoutParams2.height = this.f57911g;
                fVar2.f57917a.setLayoutParams(layoutParams2);
                fVar2.f57918b = (TbImageView) view2.findViewById(R.id.collect_pic);
                fVar2.f57919c = (ImageView) view2.findViewById(R.id.collect_select_icon);
                view2.setTag(fVar2);
                SkinManager.setBackgroundColor(view2, R.color.CAM_X0201, this.j);
            } else {
                view2 = view;
                fVar2 = (f) view.getTag();
            }
            fVar2.f57918b.setTag(null);
            fVar2.f57918b.setDefaultResource(R.drawable.img_default_100);
            fVar2.f57918b.W(null, 12, false);
            fVar2.f57918b.invalidate();
            SkinManager.setBackgroundResource(fVar2.f57918b, R.drawable.btn_choose_face_selector, this.j);
            ImageFileInfo imageFileInfo = getItem(i).imageFileInfo;
            if (imageFileInfo != null) {
                imageFileInfo.clearPageActions();
                int i2 = this.f57911g;
                imageFileInfo.addPageAction(d.b.h0.b0.g.d.g(i2, i2));
                fVar2.f57918b.setTag(imageFileInfo.toCachedKey(false));
                if (this.f57912h.c(imageFileInfo, false) != null) {
                    fVar2.f57918b.invalidate();
                } else {
                    this.f57912h.e(imageFileInfo, new a(this, viewGroup), false, false);
                }
            }
            if (this.i) {
                fVar2.f57919c.setVisibility(0);
            } else {
                fVar2.f57919c.setVisibility(8);
            }
            if (this.f57910f.contains(getItem(i))) {
                SkinManager.setBackgroundResource(fVar2.f57919c, R.drawable.ic_post_image_selected_s);
            } else {
                SkinManager.setBackgroundResource(fVar2.f57919c, R.drawable.ic_post_image_selected_n);
            }
            b bVar = new b(i);
            fVar2.f57918b.setOnClickListener(bVar);
            fVar2.f57919c.setOnClickListener(bVar);
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
        this.f57909e.clear();
        if (list == null) {
            return;
        }
        this.f57909e.addAll(list);
        notifyDataSetChanged();
    }

    public void j(boolean z) {
        if (this.i == z) {
            return;
        }
        for (CollectEmotionData collectEmotionData : this.f57910f) {
            collectEmotionData.isSelect = false;
            collectEmotionData.selectIndex = -1;
        }
        this.f57910f.clear();
        this.i = z;
        ArrayList arrayList = new ArrayList(this.f57909e);
        this.f57909e.clear();
        this.f57909e.addAll(arrayList);
        notifyDataSetChanged();
    }

    public void k(int i) {
        this.j = i;
    }
}
