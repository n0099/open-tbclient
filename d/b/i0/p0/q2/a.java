package d.b.i0.p0.q2;

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
import d.b.b.a.f;
import java.util.List;
import tbclient.FrsPage.RecmForumInfo;
/* loaded from: classes4.dex */
public class a extends d.b.h0.d0.a {

    /* renamed from: a  reason: collision with root package name */
    public TbImageView f58410a;

    /* renamed from: b  reason: collision with root package name */
    public TextView f58411b;

    /* renamed from: c  reason: collision with root package name */
    public BdListView f58412c;

    /* renamed from: d  reason: collision with root package name */
    public C1431a f58413d;

    /* renamed from: e  reason: collision with root package name */
    public f f58414e;

    /* renamed from: f  reason: collision with root package name */
    public View f58415f;

    /* renamed from: g  reason: collision with root package name */
    public TextView f58416g;

    /* renamed from: h  reason: collision with root package name */
    public TextView f58417h;

    /* renamed from: d.b.i0.p0.q2.a$a  reason: collision with other inner class name */
    /* loaded from: classes4.dex */
    public class C1431a extends BaseAdapter {

        /* renamed from: e  reason: collision with root package name */
        public List<RecmForumInfo> f58418e;

        /* renamed from: d.b.i0.p0.q2.a$a$a  reason: collision with other inner class name */
        /* loaded from: classes4.dex */
        public class View$OnClickListenerC1432a implements View.OnClickListener {

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ int f58420e;

            public View$OnClickListenerC1432a(int i) {
                this.f58420e = i;
            }

            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (StringUtils.isNull(C1431a.this.getItem(this.f58420e).forum_name)) {
                    return;
                }
                MessageManager.getInstance().sendMessage(new CustomMessage(2003000, new FrsActivityConfig(a.this.f58414e.getContext()).createNormalCfg(C1431a.this.getItem(this.f58420e).forum_name, null)));
            }
        }

        public C1431a(List<RecmForumInfo> list) {
            this.f58418e = list;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // android.widget.Adapter
        /* renamed from: a */
        public RecmForumInfo getItem(int i) {
            return this.f58418e.get(i);
        }

        @Override // android.widget.Adapter
        public int getCount() {
            return this.f58418e.size();
        }

        @Override // android.widget.Adapter
        public long getItemId(int i) {
            return i;
        }

        @Override // android.widget.Adapter
        public View getView(int i, View view, ViewGroup viewGroup) {
            b bVar;
            if (view == null) {
                view = LayoutInflater.from(a.this.f58414e.getPageActivity()).inflate(R.layout.recommend_view, (ViewGroup) null);
                bVar = new b();
                bVar.f58427f = view.findViewById(R.id.root_view);
                bVar.f58422a = (TextView) view.findViewById(R.id.forum_name);
                bVar.f58424c = (TextView) view.findViewById(R.id.follow_tv);
                bVar.f58423b = (TextView) view.findViewById(R.id.thread_tv);
                bVar.f58425d = (ImageView) view.findViewById(R.id.arrow_item_img);
                bVar.f58426e = (TbImageView) view.findViewById(R.id.headview);
                bVar.f58428g = (TextView) view.findViewById(R.id.follow_title);
                bVar.f58429h = (TextView) view.findViewById(R.id.thread_title);
                bVar.i = view.findViewById(R.id.divider_line);
                bVar.j = (ImageView) view.findViewById(R.id.content_img);
                view.setTag(bVar);
            } else {
                bVar = (b) view.getTag();
            }
            if (getItem(i) != null) {
                bVar.f58422a.setText(StringHelper.cutChineseAndEnglishWithSuffix(getItem(i).forum_name, 14, StringHelper.STRING_MORE));
                bVar.f58426e.W(getItem(i).avatar, 10, false);
                bVar.f58424c.setText(StringHelper.numberUniformFormat(getItem(i).member_count.intValue()));
                bVar.f58423b.setText(StringHelper.numberUniformFormat(getItem(i).post_num.intValue()));
                bVar.f58427f.setOnClickListener(new View$OnClickListenerC1432a(i));
                SkinManager.setViewTextColor(bVar.f58422a, R.color.CAM_X0105);
                SkinManager.setViewTextColor(bVar.f58424c, R.color.CAM_X0109);
                SkinManager.setViewTextColor(bVar.f58423b, R.color.CAM_X0109);
                SkinManager.setViewTextColor(bVar.f58429h, R.color.CAM_X0109);
                SkinManager.setViewTextColor(bVar.f58428g, R.color.CAM_X0109);
                SkinManager.setBackgroundResource(bVar.i, R.color.CAM_X0204);
                SvgManager.getInstance().setPureDrawableWithDayNightModeAutoChange(bVar.f58425d, R.drawable.icon_pure_list_arrow16_right_svg, R.color.CAM_X0109, SvgManager.SvgResourceStateType.NORMAL);
                SkinManager.setBackgroundResource(view, R.drawable.addresslist_item_bg);
                SkinManager.setBackgroundResource(bVar.j, R.drawable.picture_content_frame);
            }
            return view;
        }
    }

    /* loaded from: classes4.dex */
    public static class b {

        /* renamed from: a  reason: collision with root package name */
        public TextView f58422a;

        /* renamed from: b  reason: collision with root package name */
        public TextView f58423b;

        /* renamed from: c  reason: collision with root package name */
        public TextView f58424c;

        /* renamed from: d  reason: collision with root package name */
        public ImageView f58425d;

        /* renamed from: e  reason: collision with root package name */
        public TbImageView f58426e;

        /* renamed from: f  reason: collision with root package name */
        public View f58427f;

        /* renamed from: g  reason: collision with root package name */
        public TextView f58428g;

        /* renamed from: h  reason: collision with root package name */
        public TextView f58429h;
        public View i;
        public ImageView j;
    }

    public a(f fVar, View.OnClickListener onClickListener) {
        super(LayoutInflater.from(fVar.getContext()).inflate(R.layout.forbid_detail_view_layout, (ViewGroup) null));
        this.f58414e = fVar;
        this.f58410a = (TbImageView) this.attachedView.findViewById(R.id.net_refresh_image);
        this.f58411b = (TextView) this.attachedView.findViewById(R.id.net_refresh_desc);
        this.f58415f = this.attachedView.findViewById(R.id.divider);
        this.f58412c = (BdListView) this.attachedView.findViewById(R.id.recommend_bar_listview);
        this.attachedView.setOnClickListener(null);
        this.f58416g = (TextView) this.attachedView.findViewById(R.id.content_title);
        this.f58417h = (TextView) this.attachedView.findViewById(R.id.local_tip_tv);
    }

    public void b(List<RecmForumInfo> list) {
        if (list == null) {
            return;
        }
        C1431a c1431a = new C1431a(list);
        this.f58413d = c1431a;
        this.f58412c.setAdapter((ListAdapter) c1431a);
    }

    public void c(String str) {
        if (str == null) {
            this.f58411b.setVisibility(8);
            return;
        }
        this.f58411b.setVisibility(0);
        this.f58411b.setText(str);
    }

    public void onChangeSkinType() {
        if (isViewAttached()) {
            int skinType = TbadkCoreApplication.getInst().getSkinType();
            SkinManager.setImageResource(this.f58410a, R.drawable.new_pic_emotion_01);
            SkinManager.setViewTextColor(this.f58411b, R.color.CAM_X0109, 1, skinType);
            SkinManager.setBackgroundColor(this.attachedView, R.color.CAM_X0201);
            SkinManager.setBackgroundColor(this.f58415f, R.color.CAM_X0204);
            SkinManager.setViewTextColor(this.f58416g, R.color.CAM_X0109, 1, skinType);
            SkinManager.setViewTextColor(this.f58417h, R.color.CAM_X0106, 1, skinType);
            C1431a c1431a = this.f58413d;
            if (c1431a != null) {
                c1431a.notifyDataSetChanged();
            }
        }
    }

    @Override // d.b.h0.d0.a
    public void onViewAttached() {
        super.onViewAttached();
        onChangeSkinType();
    }

    @Override // d.b.h0.d0.a
    public void onViewDettached() {
        super.onViewDettached();
        this.f58410a.setImageResource(0);
    }
}
