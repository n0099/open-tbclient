package d.b.i0.i1;

import android.net.Uri;
import android.text.TextUtils;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.ShareDialogConfig;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.coreExtra.share.ShareItem;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
import com.baidu.tieba.lego.activity.LegoListActivity;
import d.b.i0.c3.v;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes3.dex */
public class j {

    /* renamed from: a  reason: collision with root package name */
    public final NavigationBar f55884a;

    /* renamed from: b  reason: collision with root package name */
    public final RelativeLayout f55885b;

    /* renamed from: c  reason: collision with root package name */
    public final TextView f55886c;

    /* renamed from: d  reason: collision with root package name */
    public final TbImageView f55887d;

    /* renamed from: e  reason: collision with root package name */
    public final View f55888e;

    /* renamed from: f  reason: collision with root package name */
    public final LinearLayout f55889f;

    /* renamed from: g  reason: collision with root package name */
    public final TbImageView f55890g;

    /* renamed from: h  reason: collision with root package name */
    public final TbImageView f55891h;
    public final TbImageView i;
    public final List<TbImageView> j;
    public LegoListActivity k;

    /* loaded from: classes3.dex */
    public class a implements Runnable {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ String f55892e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ String f55893f;

        public a(String str, String str2) {
            this.f55892e = str;
            this.f55893f = str2;
        }

        @Override // java.lang.Runnable
        public void run() {
            j.this.f(this.f55892e, this.f55893f);
        }
    }

    /* loaded from: classes3.dex */
    public class b implements Runnable {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ List f55895e;

        public b(List list) {
            this.f55895e = list;
        }

        @Override // java.lang.Runnable
        public void run() {
            j.this.e(this.f55895e);
        }
    }

    /* loaded from: classes3.dex */
    public class c implements View.OnClickListener {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ String f55897e;

        public c(String str) {
            this.f55897e = str;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            v.c(j.this.k.getPageContext(), this.f55897e);
        }
    }

    /* loaded from: classes3.dex */
    public class d implements View.OnClickListener {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ d.b.i0.i1.p.d f55899e;

        public d(d.b.i0.i1.p.d dVar) {
            this.f55899e = dVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            j.this.h(this.f55899e);
        }
    }

    /* loaded from: classes3.dex */
    public class e implements View.OnClickListener {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ ShareItem f55901e;

        public e(ShareItem shareItem) {
            this.f55901e = shareItem;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            d.b.b.e.p.a.a(this.f55901e.t);
            d.b.b.e.p.l.L(j.this.k.getActivity(), view.getResources().getString(R.string.copy_pb_url_success));
        }
    }

    public j(LegoListActivity legoListActivity) {
        this.k = legoListActivity;
        NavigationBar navigationBar = (NavigationBar) legoListActivity.findViewById(R.id.view_navigation_bar);
        this.f55884a = navigationBar;
        this.f55888e = navigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON, legoListActivity.mCommonOnClickListener);
        this.f55885b = (RelativeLayout) this.f55884a.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_CENTER, R.layout.title_textview, (View.OnClickListener) null);
        ((LinearLayout) this.f55884a.getViewGroup(NavigationBar.ControlAlign.HORIZONTAL_CENTER)).setGravity(17);
        this.f55886c = (TextView) this.f55885b.findViewById(R.id.lego_title);
        this.f55887d = (TbImageView) this.f55885b.findViewById(R.id.lego_title_img);
        LinearLayout linearLayout = (LinearLayout) this.f55885b.findViewById(R.id.ll_right);
        this.f55889f = linearLayout;
        this.f55890g = (TbImageView) linearLayout.findViewById(R.id.iv1);
        this.f55891h = (TbImageView) this.f55889f.findViewById(R.id.iv2);
        this.i = (TbImageView) this.f55889f.findViewById(R.id.iv3);
        ArrayList arrayList = new ArrayList();
        this.j = arrayList;
        arrayList.add(this.f55890g);
        this.j.add(this.f55891h);
        this.j.add(this.i);
    }

    public void d() {
        this.f55884a.setVisibility(8);
    }

    public final void e(List<d.b.i0.i1.p.d> list) {
        if (ListUtils.isEmpty(list)) {
            return;
        }
        this.f55889f.setVisibility(0);
        for (int i = 0; i < list.size() && i < this.j.size(); i++) {
            this.j.get(i).setVisibility(0);
            if (list.get(i).f56026d == 2) {
                SkinManager.setImageResource(this.j.get(i), R.drawable.icon_nav_share_n);
            } else if (TbadkCoreApplication.getInst().getSkinType() == 1) {
                this.j.get(i).W(list.get(i).f56024b, 10, false);
            } else {
                this.j.get(i).W(list.get(i).f56023a, 10, false);
            }
            if (!TextUtils.isEmpty(list.get(i).f56025c)) {
                String str = list.get(i).f56025c;
                if (list.get(i).f56026d == 1) {
                    this.j.get(i).setOnClickListener(new c(str));
                } else if (list.get(i).f56026d == 2) {
                    this.j.get(i).setOnClickListener(new d(list.get(i)));
                }
            }
        }
        for (int size = list.size(); size < this.j.size(); size++) {
            this.j.get(size).setVisibility(8);
        }
    }

    public final void f(String str, String str2) {
        TbImageView tbImageView = this.f55887d;
        if (tbImageView == null || this.f55886c == null) {
            return;
        }
        tbImageView.setVisibility(0);
        this.f55886c.setVisibility(8);
        if (TbadkCoreApplication.getInst().getSkinType() == 1) {
            this.f55887d.W(str2, 10, false);
        } else {
            this.f55887d.W(str, 10, false);
        }
    }

    public void g(List<d.b.i0.i1.p.d> list) {
        if (ListUtils.isEmpty(list)) {
            this.f55889f.setVisibility(8);
            return;
        }
        e(list);
        this.f55889f.postDelayed(new b(list), 1000L);
    }

    public void h(d.b.i0.i1.p.d dVar) {
        if (dVar == null || dVar.f56026d != 2) {
            return;
        }
        String str = dVar.f56029g;
        Uri parse = str == null ? null : Uri.parse(str);
        ShareItem shareItem = new ShareItem();
        shareItem.r = dVar.f56027e;
        shareItem.s = dVar.f56028f;
        shareItem.t = dVar.f56025c;
        if (parse != null) {
            shareItem.v = parse;
        }
        ShareDialogConfig shareDialogConfig = new ShareDialogConfig(this.k.getActivity(), shareItem, true);
        shareDialogConfig.setIsCopyLink(true);
        shareDialogConfig.setCopyLinkListener(new e(shareItem));
        this.k.sendMessage(new CustomMessage(2001276, shareDialogConfig));
    }

    public void i(String str) {
        SkinManager.setViewTextColor(this.f55886c, R.color.CAM_X0105);
        this.f55886c.setVisibility(0);
        this.f55887d.setVisibility(8);
        if (!TextUtils.isEmpty(str)) {
            this.f55886c.setText(str);
        } else {
            this.f55886c.setText("");
        }
    }

    public void j(String str, String str2) {
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
            return;
        }
        f(str, str2);
        this.f55887d.postDelayed(new a(str, str2), 1000L);
    }
}
