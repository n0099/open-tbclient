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
    public TbImageView f58409a;

    /* renamed from: b  reason: collision with root package name */
    public TextView f58410b;

    /* renamed from: c  reason: collision with root package name */
    public BdListView f58411c;

    /* renamed from: d  reason: collision with root package name */
    public C1430a f58412d;

    /* renamed from: e  reason: collision with root package name */
    public f f58413e;

    /* renamed from: f  reason: collision with root package name */
    public View f58414f;

    /* renamed from: g  reason: collision with root package name */
    public TextView f58415g;

    /* renamed from: h  reason: collision with root package name */
    public TextView f58416h;

    /* renamed from: d.b.i0.p0.q2.a$a  reason: collision with other inner class name */
    /* loaded from: classes4.dex */
    public class C1430a extends BaseAdapter {

        /* renamed from: e  reason: collision with root package name */
        public List<RecmForumInfo> f58417e;

        /* renamed from: d.b.i0.p0.q2.a$a$a  reason: collision with other inner class name */
        /* loaded from: classes4.dex */
        public class View$OnClickListenerC1431a implements View.OnClickListener {

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ int f58419e;

            public View$OnClickListenerC1431a(int i) {
                this.f58419e = i;
            }

            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (StringUtils.isNull(C1430a.this.getItem(this.f58419e).forum_name)) {
                    return;
                }
                MessageManager.getInstance().sendMessage(new CustomMessage(2003000, new FrsActivityConfig(a.this.f58413e.getContext()).createNormalCfg(C1430a.this.getItem(this.f58419e).forum_name, null)));
            }
        }

        public C1430a(List<RecmForumInfo> list) {
            this.f58417e = list;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // android.widget.Adapter
        /* renamed from: a */
        public RecmForumInfo getItem(int i) {
            return this.f58417e.get(i);
        }

        @Override // android.widget.Adapter
        public int getCount() {
            return this.f58417e.size();
        }

        @Override // android.widget.Adapter
        public long getItemId(int i) {
            return i;
        }

        @Override // android.widget.Adapter
        public View getView(int i, View view, ViewGroup viewGroup) {
            b bVar;
            if (view == null) {
                view = LayoutInflater.from(a.this.f58413e.getPageActivity()).inflate(R.layout.recommend_view, (ViewGroup) null);
                bVar = new b();
                bVar.f58426f = view.findViewById(R.id.root_view);
                bVar.f58421a = (TextView) view.findViewById(R.id.forum_name);
                bVar.f58423c = (TextView) view.findViewById(R.id.follow_tv);
                bVar.f58422b = (TextView) view.findViewById(R.id.thread_tv);
                bVar.f58424d = (ImageView) view.findViewById(R.id.arrow_item_img);
                bVar.f58425e = (TbImageView) view.findViewById(R.id.headview);
                bVar.f58427g = (TextView) view.findViewById(R.id.follow_title);
                bVar.f58428h = (TextView) view.findViewById(R.id.thread_title);
                bVar.i = view.findViewById(R.id.divider_line);
                bVar.j = (ImageView) view.findViewById(R.id.content_img);
                view.setTag(bVar);
            } else {
                bVar = (b) view.getTag();
            }
            if (getItem(i) != null) {
                bVar.f58421a.setText(StringHelper.cutChineseAndEnglishWithSuffix(getItem(i).forum_name, 14, StringHelper.STRING_MORE));
                bVar.f58425e.W(getItem(i).avatar, 10, false);
                bVar.f58423c.setText(StringHelper.numberUniformFormat(getItem(i).member_count.intValue()));
                bVar.f58422b.setText(StringHelper.numberUniformFormat(getItem(i).post_num.intValue()));
                bVar.f58426f.setOnClickListener(new View$OnClickListenerC1431a(i));
                SkinManager.setViewTextColor(bVar.f58421a, R.color.CAM_X0105);
                SkinManager.setViewTextColor(bVar.f58423c, R.color.CAM_X0109);
                SkinManager.setViewTextColor(bVar.f58422b, R.color.CAM_X0109);
                SkinManager.setViewTextColor(bVar.f58428h, R.color.CAM_X0109);
                SkinManager.setViewTextColor(bVar.f58427g, R.color.CAM_X0109);
                SkinManager.setBackgroundResource(bVar.i, R.color.CAM_X0204);
                SvgManager.getInstance().setPureDrawableWithDayNightModeAutoChange(bVar.f58424d, R.drawable.icon_pure_list_arrow16_right_svg, R.color.CAM_X0109, SvgManager.SvgResourceStateType.NORMAL);
                SkinManager.setBackgroundResource(view, R.drawable.addresslist_item_bg);
                SkinManager.setBackgroundResource(bVar.j, R.drawable.picture_content_frame);
            }
            return view;
        }
    }

    /* loaded from: classes4.dex */
    public static class b {

        /* renamed from: a  reason: collision with root package name */
        public TextView f58421a;

        /* renamed from: b  reason: collision with root package name */
        public TextView f58422b;

        /* renamed from: c  reason: collision with root package name */
        public TextView f58423c;

        /* renamed from: d  reason: collision with root package name */
        public ImageView f58424d;

        /* renamed from: e  reason: collision with root package name */
        public TbImageView f58425e;

        /* renamed from: f  reason: collision with root package name */
        public View f58426f;

        /* renamed from: g  reason: collision with root package name */
        public TextView f58427g;

        /* renamed from: h  reason: collision with root package name */
        public TextView f58428h;
        public View i;
        public ImageView j;
    }

    public a(f fVar, View.OnClickListener onClickListener) {
        super(LayoutInflater.from(fVar.getContext()).inflate(R.layout.forbid_detail_view_layout, (ViewGroup) null));
        this.f58413e = fVar;
        this.f58409a = (TbImageView) this.attachedView.findViewById(R.id.net_refresh_image);
        this.f58410b = (TextView) this.attachedView.findViewById(R.id.net_refresh_desc);
        this.f58414f = this.attachedView.findViewById(R.id.divider);
        this.f58411c = (BdListView) this.attachedView.findViewById(R.id.recommend_bar_listview);
        this.attachedView.setOnClickListener(null);
        this.f58415g = (TextView) this.attachedView.findViewById(R.id.content_title);
        this.f58416h = (TextView) this.attachedView.findViewById(R.id.local_tip_tv);
    }

    public void b(List<RecmForumInfo> list) {
        if (list == null) {
            return;
        }
        C1430a c1430a = new C1430a(list);
        this.f58412d = c1430a;
        this.f58411c.setAdapter((ListAdapter) c1430a);
    }

    public void c(String str) {
        if (str == null) {
            this.f58410b.setVisibility(8);
            return;
        }
        this.f58410b.setVisibility(0);
        this.f58410b.setText(str);
    }

    public void onChangeSkinType() {
        if (isViewAttached()) {
            int skinType = TbadkCoreApplication.getInst().getSkinType();
            SkinManager.setImageResource(this.f58409a, R.drawable.new_pic_emotion_01);
            SkinManager.setViewTextColor(this.f58410b, R.color.CAM_X0109, 1, skinType);
            SkinManager.setBackgroundColor(this.attachedView, R.color.CAM_X0201);
            SkinManager.setBackgroundColor(this.f58414f, R.color.CAM_X0204);
            SkinManager.setViewTextColor(this.f58415g, R.color.CAM_X0109, 1, skinType);
            SkinManager.setViewTextColor(this.f58416h, R.color.CAM_X0106, 1, skinType);
            C1430a c1430a = this.f58412d;
            if (c1430a != null) {
                c1430a.notifyDataSetChanged();
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
        this.f58409a.setImageResource(0);
    }
}
