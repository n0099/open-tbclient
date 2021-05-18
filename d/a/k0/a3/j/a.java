package d.a.k0.a3.j;

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
import d.a.c.e.p.l;
import java.util.ArrayList;
/* loaded from: classes5.dex */
public class a extends BaseAdapter {

    /* renamed from: e  reason: collision with root package name */
    public Activity f52007e;

    /* renamed from: f  reason: collision with root package name */
    public ArrayList<d> f52008f;

    /* renamed from: g  reason: collision with root package name */
    public View.OnClickListener f52009g = new View$OnClickListenerC1208a();

    /* renamed from: d.a.k0.a3.j.a$a  reason: collision with other inner class name */
    /* loaded from: classes5.dex */
    public class View$OnClickListenerC1208a implements View.OnClickListener {
        public View$OnClickListenerC1208a() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            d dVar;
            Object tag = view.getTag();
            if ((tag instanceof b) && (dVar = ((b) tag).f52014d) != null) {
                if (dVar.f52017a == null) {
                    BarFolderFirstDirActivity.k(a.this.c(), null);
                } else {
                    MessageManager.getInstance().sendMessage(new CustomMessage(2902025, new ForumListActivityConfig(a.this.c(), dVar.f52018b, dVar.f52017a, dVar.f52019c)));
                }
            }
        }
    }

    /* loaded from: classes5.dex */
    public static class b {

        /* renamed from: a  reason: collision with root package name */
        public BarImageView f52011a;

        /* renamed from: b  reason: collision with root package name */
        public TextView f52012b;

        /* renamed from: c  reason: collision with root package name */
        public BestStringsFitTextView f52013c;

        /* renamed from: d  reason: collision with root package name */
        public d f52014d;
    }

    public a(Activity activity, d.a.k0.a3.j.b bVar, boolean z) {
        this.f52007e = activity;
        this.f52008f = bVar.h();
    }

    public final View a(ViewGroup viewGroup, int i2) {
        if (i2 == 3) {
            return LayoutInflater.from(this.f52007e).inflate(R.layout.bar_home_list_line, viewGroup, false);
        }
        if (i2 == 2) {
            return LayoutInflater.from(this.f52007e).inflate(R.layout.bar_folder_first_dir_bottom_item, viewGroup, false);
        }
        View inflate = LayoutInflater.from(this.f52007e).inflate(R.layout.bar_folder_first_dir_item, viewGroup, false);
        inflate.setOnClickListener(this.f52009g);
        b bVar = new b();
        bVar.f52011a = (BarImageView) inflate.findViewById(R.id.portrait);
        bVar.f52012b = (TextView) inflate.findViewById(R.id.name);
        bVar.f52013c = (BestStringsFitTextView) inflate.findViewById(R.id.description);
        inflate.setTag(bVar);
        return inflate;
    }

    public final void b(ViewGroup viewGroup, b bVar, int i2) {
        d dVar = this.f52008f.get(i2 / 2);
        bVar.f52014d = dVar;
        bVar.f52012b.setText(dVar.f52018b);
        if (dVar.f52021e != null) {
            bVar.f52013c.setVisibility(0);
            String[] strArr = new String[dVar.f52021e.size()];
            for (int i3 = 0; i3 < dVar.f52021e.size(); i3++) {
                strArr[i3] = dVar.f52021e.get(i3).f52018b;
            }
            bVar.f52013c.setTextArray(strArr);
        } else {
            bVar.f52013c.setVisibility(8);
        }
        if (dVar.f52020d != null) {
            int e2 = l.e(this.f52007e, 45.0f);
            bVar.f52011a.setTag(dVar.f52020d);
            bVar.f52011a.R(dVar.f52020d, 10, e2, e2, false);
        }
    }

    public Activity c() {
        return this.f52007e;
    }

    public ArrayList<d> d() {
        return this.f52008f;
    }

    public void e(ArrayList<d> arrayList) {
        this.f52008f = arrayList;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        ArrayList<d> arrayList = this.f52008f;
        if (arrayList == null) {
            return 0;
        }
        return (arrayList.size() * 2) + 1;
    }

    @Override // android.widget.Adapter
    public Object getItem(int i2) {
        return null;
    }

    @Override // android.widget.Adapter
    public long getItemId(int i2) {
        return 0L;
    }

    @Override // android.widget.BaseAdapter, android.widget.Adapter
    public int getItemViewType(int i2) {
        if (getCount() <= 0 || i2 != getCount() - 1) {
            return Math.abs(i2) % 2 == 1 ? 3 : 1;
        }
        return 2;
    }

    @Override // android.widget.Adapter
    public View getView(int i2, View view, ViewGroup viewGroup) {
        int itemViewType = getItemViewType(i2);
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
            b(viewGroup, (b) view.getTag(), i2);
        }
        return view;
    }

    @Override // android.widget.BaseAdapter, android.widget.Adapter
    public int getViewTypeCount() {
        return 4;
    }
}
