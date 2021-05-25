package d.a.n0.r0.r2;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ListAdapter;
import android.widget.TextView;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.adp.widget.ListView.BdListView;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.FrsActivityConfig;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.StringHelper;
import com.baidu.tbadk.core.util.SvgManager;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
import d.a.c.a.f;
import java.util.List;
import tbclient.FrsPage.RecmForumInfo;
/* loaded from: classes4.dex */
public class a extends d.a.m0.d0.a {

    /* renamed from: a  reason: collision with root package name */
    public TbImageView f59531a;

    /* renamed from: b  reason: collision with root package name */
    public TextView f59532b;

    /* renamed from: c  reason: collision with root package name */
    public BdListView f59533c;

    /* renamed from: d  reason: collision with root package name */
    public C1545a f59534d;

    /* renamed from: e  reason: collision with root package name */
    public f f59535e;

    /* renamed from: f  reason: collision with root package name */
    public View f59536f;

    /* renamed from: g  reason: collision with root package name */
    public TextView f59537g;

    /* renamed from: h  reason: collision with root package name */
    public TextView f59538h;

    /* renamed from: d.a.n0.r0.r2.a$a  reason: collision with other inner class name */
    /* loaded from: classes4.dex */
    public class C1545a extends BaseAdapter {

        /* renamed from: e  reason: collision with root package name */
        public List<RecmForumInfo> f59539e;

        /* renamed from: d.a.n0.r0.r2.a$a$a  reason: collision with other inner class name */
        /* loaded from: classes4.dex */
        public class View$OnClickListenerC1546a implements View.OnClickListener {

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ int f59541e;

            public View$OnClickListenerC1546a(int i2) {
                this.f59541e = i2;
            }

            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (StringUtils.isNull(C1545a.this.getItem(this.f59541e).forum_name)) {
                    return;
                }
                MessageManager.getInstance().sendMessage(new CustomMessage(2003000, new FrsActivityConfig(a.this.f59535e.getContext()).createNormalCfg(C1545a.this.getItem(this.f59541e).forum_name, null)));
            }
        }

        public C1545a(List<RecmForumInfo> list) {
            this.f59539e = list;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // android.widget.Adapter
        /* renamed from: a */
        public RecmForumInfo getItem(int i2) {
            return this.f59539e.get(i2);
        }

        @Override // android.widget.Adapter
        public int getCount() {
            return this.f59539e.size();
        }

        @Override // android.widget.Adapter
        public long getItemId(int i2) {
            return i2;
        }

        @Override // android.widget.Adapter
        public View getView(int i2, View view, ViewGroup viewGroup) {
            b bVar;
            if (view == null) {
                view = LayoutInflater.from(a.this.f59535e.getPageActivity()).inflate(R.layout.recommend_view, (ViewGroup) null);
                bVar = new b();
                bVar.f59548f = view.findViewById(R.id.root_view);
                bVar.f59543a = (TextView) view.findViewById(R.id.forum_name);
                bVar.f59545c = (TextView) view.findViewById(R.id.follow_tv);
                bVar.f59544b = (TextView) view.findViewById(R.id.thread_tv);
                bVar.f59546d = (ImageView) view.findViewById(R.id.arrow_item_img);
                bVar.f59547e = (TbImageView) view.findViewById(R.id.headview);
                bVar.f59549g = (TextView) view.findViewById(R.id.follow_title);
                bVar.f59550h = (TextView) view.findViewById(R.id.thread_title);
                bVar.f59551i = view.findViewById(R.id.divider_line);
                bVar.j = (ImageView) view.findViewById(R.id.content_img);
                view.setTag(bVar);
            } else {
                bVar = (b) view.getTag();
            }
            if (getItem(i2) != null) {
                bVar.f59543a.setText(StringHelper.cutChineseAndEnglishWithSuffix(getItem(i2).forum_name, 14, StringHelper.STRING_MORE));
                bVar.f59547e.V(getItem(i2).avatar, 10, false);
                bVar.f59545c.setText(StringHelper.numberUniformFormat(getItem(i2).member_count.intValue()));
                bVar.f59544b.setText(StringHelper.numberUniformFormat(getItem(i2).post_num.intValue()));
                bVar.f59548f.setOnClickListener(new View$OnClickListenerC1546a(i2));
                SkinManager.setViewTextColor(bVar.f59543a, R.color.CAM_X0105);
                SkinManager.setViewTextColor(bVar.f59545c, R.color.CAM_X0109);
                SkinManager.setViewTextColor(bVar.f59544b, R.color.CAM_X0109);
                SkinManager.setViewTextColor(bVar.f59550h, R.color.CAM_X0109);
                SkinManager.setViewTextColor(bVar.f59549g, R.color.CAM_X0109);
                SkinManager.setBackgroundResource(bVar.f59551i, R.color.CAM_X0204);
                SvgManager.getInstance().setPureDrawableWithDayNightModeAutoChange(bVar.f59546d, R.drawable.icon_pure_list_arrow16_right_svg, R.color.CAM_X0109, SvgManager.SvgResourceStateType.NORMAL);
                SkinManager.setBackgroundResource(view, R.drawable.addresslist_item_bg);
                SkinManager.setBackgroundResource(bVar.j, R.drawable.picture_content_frame);
            }
            return view;
        }
    }

    /* loaded from: classes4.dex */
    public static class b {

        /* renamed from: a  reason: collision with root package name */
        public TextView f59543a;

        /* renamed from: b  reason: collision with root package name */
        public TextView f59544b;

        /* renamed from: c  reason: collision with root package name */
        public TextView f59545c;

        /* renamed from: d  reason: collision with root package name */
        public ImageView f59546d;

        /* renamed from: e  reason: collision with root package name */
        public TbImageView f59547e;

        /* renamed from: f  reason: collision with root package name */
        public View f59548f;

        /* renamed from: g  reason: collision with root package name */
        public TextView f59549g;

        /* renamed from: h  reason: collision with root package name */
        public TextView f59550h;

        /* renamed from: i  reason: collision with root package name */
        public View f59551i;
        public ImageView j;
    }

    public a(f fVar, View.OnClickListener onClickListener) {
        super(LayoutInflater.from(fVar.getContext()).inflate(R.layout.forbid_detail_view_layout, (ViewGroup) null));
        this.f59535e = fVar;
        this.f59531a = (TbImageView) this.attachedView.findViewById(R.id.net_refresh_image);
        this.f59532b = (TextView) this.attachedView.findViewById(R.id.net_refresh_desc);
        this.f59536f = this.attachedView.findViewById(R.id.divider);
        this.f59533c = (BdListView) this.attachedView.findViewById(R.id.recommend_bar_listview);
        this.attachedView.setOnClickListener(null);
        this.f59537g = (TextView) this.attachedView.findViewById(R.id.content_title);
        this.f59538h = (TextView) this.attachedView.findViewById(R.id.local_tip_tv);
    }

    public void b(List<RecmForumInfo> list) {
        if (list == null) {
            return;
        }
        C1545a c1545a = new C1545a(list);
        this.f59534d = c1545a;
        this.f59533c.setAdapter((ListAdapter) c1545a);
    }

    public void c(String str) {
        if (str == null) {
            this.f59532b.setVisibility(8);
            return;
        }
        this.f59532b.setVisibility(0);
        this.f59532b.setText(str);
    }

    public void onChangeSkinType() {
        if (isViewAttached()) {
            int skinType = TbadkCoreApplication.getInst().getSkinType();
            SkinManager.setImageResource(this.f59531a, R.drawable.new_pic_emotion_01);
            SkinManager.setViewTextColor(this.f59532b, R.color.CAM_X0109, 1, skinType);
            SkinManager.setBackgroundColor(this.attachedView, R.color.CAM_X0201);
            SkinManager.setBackgroundColor(this.f59536f, R.color.CAM_X0204);
            SkinManager.setViewTextColor(this.f59537g, R.color.CAM_X0109, 1, skinType);
            SkinManager.setViewTextColor(this.f59538h, R.color.CAM_X0106, 1, skinType);
            C1545a c1545a = this.f59534d;
            if (c1545a != null) {
                c1545a.notifyDataSetChanged();
            }
        }
    }

    @Override // d.a.m0.d0.a
    public void onViewAttached() {
        super.onViewAttached();
        onChangeSkinType();
    }

    @Override // d.a.m0.d0.a
    public void onViewDettached() {
        super.onViewDettached();
        this.f59531a.setImageResource(0);
    }
}
