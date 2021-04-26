package d.a.j0.j1;

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
import d.a.j0.d3.v;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes4.dex */
public class j {

    /* renamed from: a  reason: collision with root package name */
    public final NavigationBar f55716a;

    /* renamed from: b  reason: collision with root package name */
    public final RelativeLayout f55717b;

    /* renamed from: c  reason: collision with root package name */
    public final TextView f55718c;

    /* renamed from: d  reason: collision with root package name */
    public final TbImageView f55719d;

    /* renamed from: e  reason: collision with root package name */
    public final View f55720e;

    /* renamed from: f  reason: collision with root package name */
    public final LinearLayout f55721f;

    /* renamed from: g  reason: collision with root package name */
    public final TbImageView f55722g;

    /* renamed from: h  reason: collision with root package name */
    public final TbImageView f55723h;

    /* renamed from: i  reason: collision with root package name */
    public final TbImageView f55724i;
    public final List<TbImageView> j;
    public LegoListActivity k;

    /* loaded from: classes4.dex */
    public class a implements Runnable {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ String f55725e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ String f55726f;

        public a(String str, String str2) {
            this.f55725e = str;
            this.f55726f = str2;
        }

        @Override // java.lang.Runnable
        public void run() {
            j.this.f(this.f55725e, this.f55726f);
        }
    }

    /* loaded from: classes4.dex */
    public class b implements Runnable {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ List f55728e;

        public b(List list) {
            this.f55728e = list;
        }

        @Override // java.lang.Runnable
        public void run() {
            j.this.e(this.f55728e);
        }
    }

    /* loaded from: classes4.dex */
    public class c implements View.OnClickListener {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ String f55730e;

        public c(String str) {
            this.f55730e = str;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            v.c(j.this.k.getPageContext(), this.f55730e);
        }
    }

    /* loaded from: classes4.dex */
    public class d implements View.OnClickListener {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ d.a.j0.j1.p.d f55732e;

        public d(d.a.j0.j1.p.d dVar) {
            this.f55732e = dVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            j.this.h(this.f55732e);
        }
    }

    /* loaded from: classes4.dex */
    public class e implements View.OnClickListener {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ ShareItem f55734e;

        public e(ShareItem shareItem) {
            this.f55734e = shareItem;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            d.a.c.e.p.a.a(this.f55734e.t);
            d.a.c.e.p.l.M(j.this.k.getActivity(), view.getResources().getString(R.string.copy_pb_url_success));
        }
    }

    public j(LegoListActivity legoListActivity) {
        this.k = legoListActivity;
        NavigationBar navigationBar = (NavigationBar) legoListActivity.findViewById(R.id.view_navigation_bar);
        this.f55716a = navigationBar;
        this.f55720e = navigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON, legoListActivity.mCommonOnClickListener);
        this.f55717b = (RelativeLayout) this.f55716a.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_CENTER, R.layout.title_textview, (View.OnClickListener) null);
        ((LinearLayout) this.f55716a.getViewGroup(NavigationBar.ControlAlign.HORIZONTAL_CENTER)).setGravity(17);
        this.f55718c = (TextView) this.f55717b.findViewById(R.id.lego_title);
        this.f55719d = (TbImageView) this.f55717b.findViewById(R.id.lego_title_img);
        LinearLayout linearLayout = (LinearLayout) this.f55717b.findViewById(R.id.ll_right);
        this.f55721f = linearLayout;
        this.f55722g = (TbImageView) linearLayout.findViewById(R.id.iv1);
        this.f55723h = (TbImageView) this.f55721f.findViewById(R.id.iv2);
        this.f55724i = (TbImageView) this.f55721f.findViewById(R.id.iv3);
        ArrayList arrayList = new ArrayList();
        this.j = arrayList;
        arrayList.add(this.f55722g);
        this.j.add(this.f55723h);
        this.j.add(this.f55724i);
    }

    public void d() {
        this.f55716a.setVisibility(8);
    }

    public final void e(List<d.a.j0.j1.p.d> list) {
        if (ListUtils.isEmpty(list)) {
            return;
        }
        this.f55721f.setVisibility(0);
        for (int i2 = 0; i2 < list.size() && i2 < this.j.size(); i2++) {
            this.j.get(i2).setVisibility(0);
            if (list.get(i2).f55866d == 2) {
                SkinManager.setImageResource(this.j.get(i2), R.drawable.icon_nav_share_n);
            } else if (TbadkCoreApplication.getInst().getSkinType() == 1) {
                this.j.get(i2).V(list.get(i2).f55864b, 10, false);
            } else {
                this.j.get(i2).V(list.get(i2).f55863a, 10, false);
            }
            if (!TextUtils.isEmpty(list.get(i2).f55865c)) {
                String str = list.get(i2).f55865c;
                if (list.get(i2).f55866d == 1) {
                    this.j.get(i2).setOnClickListener(new c(str));
                } else if (list.get(i2).f55866d == 2) {
                    this.j.get(i2).setOnClickListener(new d(list.get(i2)));
                }
            }
        }
        for (int size = list.size(); size < this.j.size(); size++) {
            this.j.get(size).setVisibility(8);
        }
    }

    public final void f(String str, String str2) {
        TbImageView tbImageView = this.f55719d;
        if (tbImageView == null || this.f55718c == null) {
            return;
        }
        tbImageView.setVisibility(0);
        this.f55718c.setVisibility(8);
        if (TbadkCoreApplication.getInst().getSkinType() == 1) {
            this.f55719d.V(str2, 10, false);
        } else {
            this.f55719d.V(str, 10, false);
        }
    }

    public void g(List<d.a.j0.j1.p.d> list) {
        if (ListUtils.isEmpty(list)) {
            this.f55721f.setVisibility(8);
            return;
        }
        e(list);
        this.f55721f.postDelayed(new b(list), 1000L);
    }

    public void h(d.a.j0.j1.p.d dVar) {
        if (dVar == null || dVar.f55866d != 2) {
            return;
        }
        String str = dVar.f55869g;
        Uri parse = str == null ? null : Uri.parse(str);
        ShareItem shareItem = new ShareItem();
        shareItem.r = dVar.f55867e;
        shareItem.s = dVar.f55868f;
        shareItem.t = dVar.f55865c;
        if (parse != null) {
            shareItem.v = parse;
        }
        ShareDialogConfig shareDialogConfig = new ShareDialogConfig(this.k.getActivity(), shareItem, true);
        shareDialogConfig.setIsCopyLink(true);
        shareDialogConfig.setCopyLinkListener(new e(shareItem));
        this.k.sendMessage(new CustomMessage(2001276, shareDialogConfig));
    }

    public void i(String str) {
        SkinManager.setViewTextColor(this.f55718c, R.color.CAM_X0105);
        this.f55718c.setVisibility(0);
        this.f55719d.setVisibility(8);
        if (!TextUtils.isEmpty(str)) {
            this.f55718c.setText(str);
        } else {
            this.f55718c.setText("");
        }
    }

    public void j(String str, String str2) {
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
            return;
        }
        f(str, str2);
        this.f55719d.postDelayed(new a(str, str2), 1000L);
    }
}
