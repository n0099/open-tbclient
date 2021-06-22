package d.a.o0.r0.r2;

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
public class a extends d.a.n0.d0.a {

    /* renamed from: a  reason: collision with root package name */
    public TbImageView f63347a;

    /* renamed from: b  reason: collision with root package name */
    public TextView f63348b;

    /* renamed from: c  reason: collision with root package name */
    public BdListView f63349c;

    /* renamed from: d  reason: collision with root package name */
    public C1605a f63350d;

    /* renamed from: e  reason: collision with root package name */
    public f f63351e;

    /* renamed from: f  reason: collision with root package name */
    public View f63352f;

    /* renamed from: g  reason: collision with root package name */
    public TextView f63353g;

    /* renamed from: h  reason: collision with root package name */
    public TextView f63354h;

    /* renamed from: d.a.o0.r0.r2.a$a  reason: collision with other inner class name */
    /* loaded from: classes4.dex */
    public class C1605a extends BaseAdapter {

        /* renamed from: e  reason: collision with root package name */
        public List<RecmForumInfo> f63355e;

        /* renamed from: d.a.o0.r0.r2.a$a$a  reason: collision with other inner class name */
        /* loaded from: classes4.dex */
        public class View$OnClickListenerC1606a implements View.OnClickListener {

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ int f63357e;

            public View$OnClickListenerC1606a(int i2) {
                this.f63357e = i2;
            }

            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (StringUtils.isNull(C1605a.this.getItem(this.f63357e).forum_name)) {
                    return;
                }
                MessageManager.getInstance().sendMessage(new CustomMessage(2003000, new FrsActivityConfig(a.this.f63351e.getContext()).createNormalCfg(C1605a.this.getItem(this.f63357e).forum_name, null)));
            }
        }

        public C1605a(List<RecmForumInfo> list) {
            this.f63355e = list;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // android.widget.Adapter
        /* renamed from: a */
        public RecmForumInfo getItem(int i2) {
            return this.f63355e.get(i2);
        }

        @Override // android.widget.Adapter
        public int getCount() {
            return this.f63355e.size();
        }

        @Override // android.widget.Adapter
        public long getItemId(int i2) {
            return i2;
        }

        @Override // android.widget.Adapter
        public View getView(int i2, View view, ViewGroup viewGroup) {
            b bVar;
            if (view == null) {
                view = LayoutInflater.from(a.this.f63351e.getPageActivity()).inflate(R.layout.recommend_view, (ViewGroup) null);
                bVar = new b();
                bVar.f63364f = view.findViewById(R.id.root_view);
                bVar.f63359a = (TextView) view.findViewById(R.id.forum_name);
                bVar.f63361c = (TextView) view.findViewById(R.id.follow_tv);
                bVar.f63360b = (TextView) view.findViewById(R.id.thread_tv);
                bVar.f63362d = (ImageView) view.findViewById(R.id.arrow_item_img);
                bVar.f63363e = (TbImageView) view.findViewById(R.id.headview);
                bVar.f63365g = (TextView) view.findViewById(R.id.follow_title);
                bVar.f63366h = (TextView) view.findViewById(R.id.thread_title);
                bVar.f63367i = view.findViewById(R.id.divider_line);
                bVar.j = (ImageView) view.findViewById(R.id.content_img);
                view.setTag(bVar);
            } else {
                bVar = (b) view.getTag();
            }
            if (getItem(i2) != null) {
                bVar.f63359a.setText(StringHelper.cutChineseAndEnglishWithSuffix(getItem(i2).forum_name, 14, StringHelper.STRING_MORE));
                bVar.f63363e.U(getItem(i2).avatar, 10, false);
                bVar.f63361c.setText(StringHelper.numberUniformFormat(getItem(i2).member_count.intValue()));
                bVar.f63360b.setText(StringHelper.numberUniformFormat(getItem(i2).post_num.intValue()));
                bVar.f63364f.setOnClickListener(new View$OnClickListenerC1606a(i2));
                SkinManager.setViewTextColor(bVar.f63359a, R.color.CAM_X0105);
                SkinManager.setViewTextColor(bVar.f63361c, R.color.CAM_X0109);
                SkinManager.setViewTextColor(bVar.f63360b, R.color.CAM_X0109);
                SkinManager.setViewTextColor(bVar.f63366h, R.color.CAM_X0109);
                SkinManager.setViewTextColor(bVar.f63365g, R.color.CAM_X0109);
                SkinManager.setBackgroundResource(bVar.f63367i, R.color.CAM_X0204);
                SvgManager.getInstance().setPureDrawableWithDayNightModeAutoChange(bVar.f63362d, R.drawable.icon_pure_list_arrow16_right_svg, R.color.CAM_X0109, SvgManager.SvgResourceStateType.NORMAL);
                SkinManager.setBackgroundResource(view, R.drawable.addresslist_item_bg);
                SkinManager.setBackgroundResource(bVar.j, R.drawable.picture_content_frame);
            }
            return view;
        }
    }

    /* loaded from: classes4.dex */
    public static class b {

        /* renamed from: a  reason: collision with root package name */
        public TextView f63359a;

        /* renamed from: b  reason: collision with root package name */
        public TextView f63360b;

        /* renamed from: c  reason: collision with root package name */
        public TextView f63361c;

        /* renamed from: d  reason: collision with root package name */
        public ImageView f63362d;

        /* renamed from: e  reason: collision with root package name */
        public TbImageView f63363e;

        /* renamed from: f  reason: collision with root package name */
        public View f63364f;

        /* renamed from: g  reason: collision with root package name */
        public TextView f63365g;

        /* renamed from: h  reason: collision with root package name */
        public TextView f63366h;

        /* renamed from: i  reason: collision with root package name */
        public View f63367i;
        public ImageView j;
    }

    public a(f fVar, View.OnClickListener onClickListener) {
        super(LayoutInflater.from(fVar.getContext()).inflate(R.layout.forbid_detail_view_layout, (ViewGroup) null));
        this.f63351e = fVar;
        this.f63347a = (TbImageView) this.attachedView.findViewById(R.id.net_refresh_image);
        this.f63348b = (TextView) this.attachedView.findViewById(R.id.net_refresh_desc);
        this.f63352f = this.attachedView.findViewById(R.id.divider);
        this.f63349c = (BdListView) this.attachedView.findViewById(R.id.recommend_bar_listview);
        this.attachedView.setOnClickListener(null);
        this.f63353g = (TextView) this.attachedView.findViewById(R.id.content_title);
        this.f63354h = (TextView) this.attachedView.findViewById(R.id.local_tip_tv);
    }

    public void b(List<RecmForumInfo> list) {
        if (list == null) {
            return;
        }
        C1605a c1605a = new C1605a(list);
        this.f63350d = c1605a;
        this.f63349c.setAdapter((ListAdapter) c1605a);
    }

    public void c(String str) {
        if (str == null) {
            this.f63348b.setVisibility(8);
            return;
        }
        this.f63348b.setVisibility(0);
        this.f63348b.setText(str);
    }

    public void onChangeSkinType() {
        if (isViewAttached()) {
            int skinType = TbadkCoreApplication.getInst().getSkinType();
            SkinManager.setImageResource(this.f63347a, R.drawable.new_pic_emotion_01);
            SkinManager.setViewTextColor(this.f63348b, R.color.CAM_X0109, 1, skinType);
            SkinManager.setBackgroundColor(this.attachedView, R.color.CAM_X0201);
            SkinManager.setBackgroundColor(this.f63352f, R.color.CAM_X0204);
            SkinManager.setViewTextColor(this.f63353g, R.color.CAM_X0109, 1, skinType);
            SkinManager.setViewTextColor(this.f63354h, R.color.CAM_X0106, 1, skinType);
            C1605a c1605a = this.f63350d;
            if (c1605a != null) {
                c1605a.notifyDataSetChanged();
            }
        }
    }

    @Override // d.a.n0.d0.a
    public void onViewAttached() {
        super.onViewAttached();
        onChangeSkinType();
    }

    @Override // d.a.n0.d0.a
    public void onViewDettached() {
        super.onViewDettached();
        this.f63347a.setImageResource(0);
    }
}
