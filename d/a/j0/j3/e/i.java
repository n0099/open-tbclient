package d.a.j0.j3.e;

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
    public BackgroundPreviewActivity f56144a;

    /* renamed from: b  reason: collision with root package name */
    public View f56145b;

    /* renamed from: c  reason: collision with root package name */
    public BdExpandImageView f56146c;

    /* renamed from: d  reason: collision with root package name */
    public TbImageView f56147d;

    /* renamed from: e  reason: collision with root package name */
    public TbImageView f56148e;

    /* renamed from: f  reason: collision with root package name */
    public TextView f56149f;

    /* renamed from: g  reason: collision with root package name */
    public ImageView f56150g;

    /* renamed from: h  reason: collision with root package name */
    public TextView f56151h;

    /* renamed from: i  reason: collision with root package name */
    public final d.a.c.e.l.c<d.a.c.j.d.a> f56152i = new a();

    /* loaded from: classes5.dex */
    public class a extends d.a.c.e.l.c<d.a.c.j.d.a> {
        public a() {
        }

        @Override // d.a.c.e.l.c
        public void onCancelled(String str) {
            super.onCancelled(str);
        }

        @Override // d.a.c.e.l.c
        public void onProgressUpdate(Object... objArr) {
            super.onProgressUpdate(objArr);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // d.a.c.e.l.c
        public void onLoaded(d.a.c.j.d.a aVar, String str, int i2) {
            if (aVar != null) {
                aVar.h(i.this.f56146c);
            }
        }
    }

    public i(BackgroundPreviewActivity backgroundPreviewActivity) {
        this.f56144a = backgroundPreviewActivity;
        View inflate = LayoutInflater.from(backgroundPreviewActivity.getPageContext().getPageActivity()).inflate(R.layout.background_preview_header, (ViewGroup) null);
        this.f56145b = inflate;
        inflate.setLayoutParams(new AbsListView.LayoutParams(-1, this.f56144a.getResources().getDimensionPixelSize(R.dimen.ds450)));
        c();
    }

    public View b() {
        return this.f56145b;
    }

    public final void c() {
        this.f56146c = (BdExpandImageView) this.f56145b.findViewById(R.id.expand_image);
        this.f56147d = (TbImageView) this.f56145b.findViewById(R.id.user_head);
        TbImageView tbImageView = (TbImageView) this.f56145b.findViewById(R.id.vip_icon);
        this.f56148e = tbImageView;
        tbImageView.setAutoChangeStyle(false);
        this.f56149f = (TextView) this.f56145b.findViewById(R.id.user_name);
        this.f56150g = (ImageView) this.f56145b.findViewById(R.id.user_sex);
        this.f56151h = (TextView) this.f56145b.findViewById(R.id.user_bar_age_num);
        this.f56147d.setDefaultResource(R.drawable.icon_default_avatar100);
    }

    public void d() {
        if (this.f56144a.getPageContext() == null) {
            return;
        }
        d.a.i0.s0.a.a(this.f56144a.getPageContext(), this.f56145b);
    }

    public void e(DressItemData dressItemData) {
        if (dressItemData == null) {
            return;
        }
        d.a.c.e.l.d.h().k(dressItemData.getExampleImgUrl(), 10, this.f56152i, 0, 0, null, new Object[0]);
        if (StringUtils.isNull(dressItemData.getPropsStateImg())) {
            this.f56151h.setText("0");
        } else {
            this.f56151h.setText(dressItemData.getPropsStateImg());
        }
        AccountData currentAccountInfo = TbadkCoreApplication.getCurrentAccountInfo();
        if (currentAccountInfo == null) {
            SkinManager.setViewTextColor(this.f56151h, R.color.CAM_X0308, 1);
            this.f56149f.setText(R.string.default_user_name);
            this.f56150g.setImageResource(R.drawable.icon_pop_boy);
            this.f56148e.setVisibility(8);
            return;
        }
        String avatar = currentAccountInfo.getAvatar();
        int memberType = currentAccountInfo.getMemberType();
        if (!TextUtils.isEmpty(avatar)) {
            this.f56147d.V(avatar, 25, false);
        }
        String memberIconUrl = currentAccountInfo.getMemberIconUrl();
        if (StringUtils.isNull(memberIconUrl)) {
            this.f56148e.setVisibility(8);
        } else {
            this.f56148e.V(memberIconUrl, 10, false);
            this.f56148e.setVisibility(0);
        }
        if (memberType > 0) {
            this.f56149f.setTextColor(this.f56144a.getResources().getColor(R.color.CAM_X0308));
        } else {
            this.f56149f.setTextColor(this.f56144a.getResources().getColor(R.color.CAM_X0111));
        }
        this.f56149f.setText(currentAccountInfo.getAccountNameShow());
        int sex = currentAccountInfo.getSex();
        if (sex == 1) {
            this.f56150g.setImageResource(R.drawable.icon_pop_boy);
        } else if (sex == 2) {
            this.f56150g.setImageResource(R.drawable.icon_pop_girl);
        } else {
            this.f56150g.setVisibility(8);
        }
    }
}
