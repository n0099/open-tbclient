package d.b.i0.j3.e;

import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.ImageView;
import android.widget.TextView;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.adp.widget.ListView.BdExpandImageView;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.AccountData;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
import com.baidu.tieba.themeCenter.background.BackgroundPreviewActivity;
import com.baidu.tieba.themeCenter.background.DressItemData;
/* loaded from: classes5.dex */
public class i {

    /* renamed from: a  reason: collision with root package name */
    public BackgroundPreviewActivity f57736a;

    /* renamed from: b  reason: collision with root package name */
    public View f57737b;

    /* renamed from: c  reason: collision with root package name */
    public BdExpandImageView f57738c;

    /* renamed from: d  reason: collision with root package name */
    public TbImageView f57739d;

    /* renamed from: e  reason: collision with root package name */
    public TbImageView f57740e;

    /* renamed from: f  reason: collision with root package name */
    public TextView f57741f;

    /* renamed from: g  reason: collision with root package name */
    public ImageView f57742g;

    /* renamed from: h  reason: collision with root package name */
    public TextView f57743h;
    public final d.b.c.e.l.c<d.b.c.j.d.a> i = new a();

    /* loaded from: classes5.dex */
    public class a extends d.b.c.e.l.c<d.b.c.j.d.a> {
        public a() {
        }

        @Override // d.b.c.e.l.c
        public void onCancelled(String str) {
            super.onCancelled(str);
        }

        @Override // d.b.c.e.l.c
        public void onProgressUpdate(Object... objArr) {
            super.onProgressUpdate(objArr);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // d.b.c.e.l.c
        public void onLoaded(d.b.c.j.d.a aVar, String str, int i) {
            if (aVar != null) {
                aVar.h(i.this.f57738c);
            }
        }
    }

    public i(BackgroundPreviewActivity backgroundPreviewActivity) {
        this.f57736a = backgroundPreviewActivity;
        View inflate = LayoutInflater.from(backgroundPreviewActivity.getPageContext().getPageActivity()).inflate(R.layout.background_preview_header, (ViewGroup) null);
        this.f57737b = inflate;
        inflate.setLayoutParams(new AbsListView.LayoutParams(-1, this.f57736a.getResources().getDimensionPixelSize(R.dimen.ds450)));
        c();
    }

    public View b() {
        return this.f57737b;
    }

    public final void c() {
        this.f57738c = (BdExpandImageView) this.f57737b.findViewById(R.id.expand_image);
        this.f57739d = (TbImageView) this.f57737b.findViewById(R.id.user_head);
        TbImageView tbImageView = (TbImageView) this.f57737b.findViewById(R.id.vip_icon);
        this.f57740e = tbImageView;
        tbImageView.setAutoChangeStyle(false);
        this.f57741f = (TextView) this.f57737b.findViewById(R.id.user_name);
        this.f57742g = (ImageView) this.f57737b.findViewById(R.id.user_sex);
        this.f57743h = (TextView) this.f57737b.findViewById(R.id.user_bar_age_num);
        this.f57739d.setDefaultResource(R.drawable.icon_default_avatar100);
    }

    public void d() {
        if (this.f57736a.getPageContext() == null) {
            return;
        }
        d.b.h0.s0.a.a(this.f57736a.getPageContext(), this.f57737b);
    }

    public void e(DressItemData dressItemData) {
        if (dressItemData == null) {
            return;
        }
        d.b.c.e.l.d.h().k(dressItemData.getExampleImgUrl(), 10, this.i, 0, 0, null, new Object[0]);
        if (StringUtils.isNull(dressItemData.getPropsStateImg())) {
            this.f57743h.setText("0");
        } else {
            this.f57743h.setText(dressItemData.getPropsStateImg());
        }
        AccountData currentAccountInfo = TbadkCoreApplication.getCurrentAccountInfo();
        if (currentAccountInfo == null) {
            SkinManager.setViewTextColor(this.f57743h, R.color.CAM_X0308, 1);
            this.f57741f.setText(R.string.default_user_name);
            this.f57742g.setImageResource(R.drawable.icon_pop_boy);
            this.f57740e.setVisibility(8);
            return;
        }
        String avatar = currentAccountInfo.getAvatar();
        int memberType = currentAccountInfo.getMemberType();
        if (!TextUtils.isEmpty(avatar)) {
            this.f57739d.W(avatar, 25, false);
        }
        String memberIconUrl = currentAccountInfo.getMemberIconUrl();
        if (StringUtils.isNull(memberIconUrl)) {
            this.f57740e.setVisibility(8);
        } else {
            this.f57740e.W(memberIconUrl, 10, false);
            this.f57740e.setVisibility(0);
        }
        if (memberType > 0) {
            this.f57741f.setTextColor(this.f57736a.getResources().getColor(R.color.CAM_X0308));
        } else {
            this.f57741f.setTextColor(this.f57736a.getResources().getColor(R.color.CAM_X0111));
        }
        this.f57741f.setText(currentAccountInfo.getAccountNameShow());
        int sex = currentAccountInfo.getSex();
        if (sex == 1) {
            this.f57742g.setImageResource(R.drawable.icon_pop_boy);
        } else if (sex == 2) {
            this.f57742g.setImageResource(R.drawable.icon_pop_girl);
        } else {
            this.f57742g.setVisibility(8);
        }
    }
}
