package d.b.j0.a3.j;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.ForumListActivityConfig;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.ViewHelper;
import com.baidu.tbadk.core.view.BarImageView;
import com.baidu.tieba.R;
import com.baidu.tieba.square.square.BarFolderFirstDirActivity;
import com.baidu.tieba.square.view.BestStringsFitTextView;
import d.b.c.e.p.l;
import java.util.ArrayList;
/* loaded from: classes4.dex */
public class a extends BaseAdapter {

    /* renamed from: e  reason: collision with root package name */
    public Activity f53572e;

    /* renamed from: f  reason: collision with root package name */
    public ArrayList<d> f53573f;

    /* renamed from: g  reason: collision with root package name */
    public View.OnClickListener f53574g = new View$OnClickListenerC1197a();

    /* renamed from: d.b.j0.a3.j.a$a  reason: collision with other inner class name */
    /* loaded from: classes4.dex */
    public class View$OnClickListenerC1197a implements View.OnClickListener {
        public View$OnClickListenerC1197a() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            d dVar;
            Object tag = view.getTag();
            if ((tag instanceof b) && (dVar = ((b) tag).f53579d) != null) {
                if (dVar.f53582a == null) {
                    BarFolderFirstDirActivity.k(a.this.c(), null);
                } else {
                    MessageManager.getInstance().sendMessage(new CustomMessage(2902025, new ForumListActivityConfig(a.this.c(), dVar.f53583b, dVar.f53582a, dVar.f53584c)));
                }
            }
        }
    }

    /* loaded from: classes4.dex */
    public static class b {

        /* renamed from: a  reason: collision with root package name */
        public BarImageView f53576a;

        /* renamed from: b  reason: collision with root package name */
        public TextView f53577b;

        /* renamed from: c  reason: collision with root package name */
        public BestStringsFitTextView f53578c;

        /* renamed from: d  reason: collision with root package name */
        public d f53579d;
    }

    public a(Activity activity, d.b.j0.a3.j.b bVar, boolean z) {
        this.f53572e = activity;
        this.f53573f = bVar.h();
    }

    public final View a(ViewGroup viewGroup, int i) {
        if (i == 3) {
            return LayoutInflater.from(this.f53572e).inflate(R.layout.bar_home_list_line, viewGroup, false);
        }
        if (i == 2) {
            return LayoutInflater.from(this.f53572e).inflate(R.layout.bar_folder_first_dir_bottom_item, viewGroup, false);
        }
        View inflate = LayoutInflater.from(this.f53572e).inflate(R.layout.bar_folder_first_dir_item, viewGroup, false);
        inflate.setOnClickListener(this.f53574g);
        b bVar = new b();
        bVar.f53576a = (BarImageView) inflate.findViewById(R.id.portrait);
        bVar.f53577b = (TextView) inflate.findViewById(R.id.name);
        bVar.f53578c = (BestStringsFitTextView) inflate.findViewById(R.id.description);
        inflate.setTag(bVar);
        return inflate;
    }

    public final void b(ViewGroup viewGroup, b bVar, int i) {
        d dVar = this.f53573f.get(i / 2);
        bVar.f53579d = dVar;
        bVar.f53577b.setText(dVar.f53583b);
        if (dVar.f53586e != null) {
            bVar.f53578c.setVisibility(0);
            String[] strArr = new String[dVar.f53586e.size()];
            for (int i2 = 0; i2 < dVar.f53586e.size(); i2++) {
                strArr[i2] = dVar.f53586e.get(i2).f53583b;
            }
            bVar.f53578c.setTextArray(strArr);
        } else {
            bVar.f53578c.setVisibility(8);
        }
        if (dVar.f53585d != null) {
            int e2 = l.e(this.f53572e, 45.0f);
            bVar.f53576a.setTag(dVar.f53585d);
            bVar.f53576a.T(dVar.f53585d, 10, e2, e2, false);
        }
    }

    public Activity c() {
        return this.f53572e;
    }

    public ArrayList<d> d() {
        return this.f53573f;
    }

    public void e(ArrayList<d> arrayList) {
        this.f53573f = arrayList;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        ArrayList<d> arrayList = this.f53573f;
        if (arrayList == null) {
            return 0;
        }
        return (arrayList.size() * 2) + 1;
    }

    @Override // android.widget.Adapter
    public Object getItem(int i) {
        return null;
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        return 0L;
    }

    @Override // android.widget.BaseAdapter, android.widget.Adapter
    public int getItemViewType(int i) {
        if (getCount() <= 0 || i != getCount() - 1) {
            return Math.abs(i) % 2 == 1 ? 3 : 1;
        }
        return 2;
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        int itemViewType = getItemViewType(i);
        if (view == null) {
            view = a(viewGroup, itemViewType);
            ViewHelper.prepareNewView(view);
        }
        ViewHelper.processCurrentSkin(view);
        if (itemViewType == 3) {
            return view;
        }
        TbadkCoreApplication.getInst().getSkinType();
        View findViewById = view.findViewById(R.id.container);
        SkinManager.setBackgroundResource(findViewById, R.drawable.addresslist_item_bg);
        if (itemViewType == 2) {
            if (getCount() > 1) {
                findViewById.setVisibility(0);
            }
        } else if (itemViewType == 1) {
            b(viewGroup, (b) view.getTag(), i);
        }
        return view;
    }

    @Override // android.widget.BaseAdapter, android.widget.Adapter
    public int getViewTypeCount() {
        return 4;
    }
}
