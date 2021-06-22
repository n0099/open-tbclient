package d.a.o0.b3.j;

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
    public Activity f55988e;

    /* renamed from: f  reason: collision with root package name */
    public ArrayList<d> f55989f;

    /* renamed from: g  reason: collision with root package name */
    public View.OnClickListener f55990g = new View$OnClickListenerC1285a();

    /* renamed from: d.a.o0.b3.j.a$a  reason: collision with other inner class name */
    /* loaded from: classes5.dex */
    public class View$OnClickListenerC1285a implements View.OnClickListener {
        public View$OnClickListenerC1285a() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            d dVar;
            Object tag = view.getTag();
            if ((tag instanceof b) && (dVar = ((b) tag).f55995d) != null) {
                if (dVar.f55998a == null) {
                    BarFolderFirstDirActivity.k(a.this.c(), null);
                } else {
                    MessageManager.getInstance().sendMessage(new CustomMessage(2902025, new ForumListActivityConfig(a.this.c(), dVar.f55999b, dVar.f55998a, dVar.f56000c)));
                }
            }
        }
    }

    /* loaded from: classes5.dex */
    public static class b {

        /* renamed from: a  reason: collision with root package name */
        public BarImageView f55992a;

        /* renamed from: b  reason: collision with root package name */
        public TextView f55993b;

        /* renamed from: c  reason: collision with root package name */
        public BestStringsFitTextView f55994c;

        /* renamed from: d  reason: collision with root package name */
        public d f55995d;
    }

    public a(Activity activity, d.a.o0.b3.j.b bVar, boolean z) {
        this.f55988e = activity;
        this.f55989f = bVar.h();
    }

    public final View a(ViewGroup viewGroup, int i2) {
        if (i2 == 3) {
            return LayoutInflater.from(this.f55988e).inflate(R.layout.bar_home_list_line, viewGroup, false);
        }
        if (i2 == 2) {
            return LayoutInflater.from(this.f55988e).inflate(R.layout.bar_folder_first_dir_bottom_item, viewGroup, false);
        }
        View inflate = LayoutInflater.from(this.f55988e).inflate(R.layout.bar_folder_first_dir_item, viewGroup, false);
        inflate.setOnClickListener(this.f55990g);
        b bVar = new b();
        bVar.f55992a = (BarImageView) inflate.findViewById(R.id.portrait);
        bVar.f55993b = (TextView) inflate.findViewById(R.id.name);
        bVar.f55994c = (BestStringsFitTextView) inflate.findViewById(R.id.description);
        inflate.setTag(bVar);
        return inflate;
    }

    public final void b(ViewGroup viewGroup, b bVar, int i2) {
        d dVar = this.f55989f.get(i2 / 2);
        bVar.f55995d = dVar;
        bVar.f55993b.setText(dVar.f55999b);
        if (dVar.f56002e != null) {
            bVar.f55994c.setVisibility(0);
            String[] strArr = new String[dVar.f56002e.size()];
            for (int i3 = 0; i3 < dVar.f56002e.size(); i3++) {
                strArr[i3] = dVar.f56002e.get(i3).f55999b;
            }
            bVar.f55994c.setTextArray(strArr);
        } else {
            bVar.f55994c.setVisibility(8);
        }
        if (dVar.f56001d != null) {
            int e2 = l.e(this.f55988e, 45.0f);
            bVar.f55992a.setTag(dVar.f56001d);
            bVar.f55992a.R(dVar.f56001d, 10, e2, e2, false);
        }
    }

    public Activity c() {
        return this.f55988e;
    }

    public ArrayList<d> d() {
        return this.f55989f;
    }

    public void e(ArrayList<d> arrayList) {
        this.f55989f = arrayList;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        ArrayList<d> arrayList = this.f55989f;
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
