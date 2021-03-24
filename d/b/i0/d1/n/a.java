package d.b.i0.d1.n;

import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.view.GroupImageView;
import com.baidu.tieba.R;
import com.baidu.tieba.im.data.GroupInfoData;
import com.baidu.tieba.im.mygroup.PersonalGroupFragment;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes4.dex */
public class a extends BaseAdapter {

    /* renamed from: e  reason: collision with root package name */
    public PersonalGroupFragment f53930e;

    /* renamed from: f  reason: collision with root package name */
    public List<GroupInfoData> f53931f = new ArrayList();

    /* renamed from: d.b.i0.d1.n.a$a  reason: collision with other inner class name */
    /* loaded from: classes4.dex */
    public static class C1204a {

        /* renamed from: a  reason: collision with root package name */
        public LinearLayout f53932a;

        /* renamed from: b  reason: collision with root package name */
        public GroupImageView f53933b;

        /* renamed from: c  reason: collision with root package name */
        public TextView f53934c;

        /* renamed from: d  reason: collision with root package name */
        public TextView f53935d;

        /* renamed from: e  reason: collision with root package name */
        public TextView f53936e;

        /* renamed from: f  reason: collision with root package name */
        public TextView f53937f;

        /* renamed from: g  reason: collision with root package name */
        public ImageView f53938g;

        /* renamed from: h  reason: collision with root package name */
        public ImageView f53939h;
        public ImageView i;
        public ImageView j;
        public ImageView k;
        public ImageView l;
        public ImageView[] m;
    }

    public a(PersonalGroupFragment personalGroupFragment) {
        this.f53930e = personalGroupFragment;
    }

    public final void a(ImageView[] imageViewArr, int i) {
        if (i < 0) {
            i = 0;
        }
        if (i > 3) {
            i = 3;
        }
        for (int i2 = 1; i2 <= 3; i2++) {
            if (i2 <= i) {
                imageViewArr[i2].setVisibility(0);
            } else {
                imageViewArr[i2].setVisibility(8);
            }
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.widget.Adapter
    /* renamed from: b */
    public GroupInfoData getItem(int i) {
        int itemId = (int) getItemId(i);
        if (itemId < 0 || itemId >= this.f53931f.size()) {
            return null;
        }
        return this.f53931f.get(itemId);
    }

    public void c(List<GroupInfoData> list) {
        this.f53931f = list;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        return this.f53931f.size();
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        return i;
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        C1204a c1204a;
        if (view != null && view.getTag() != null && (view.getTag() instanceof C1204a)) {
            c1204a = (C1204a) view.getTag();
        } else {
            view = LayoutInflater.from(this.f53930e.getActivity()).inflate(R.layout.tab_my_group_item, viewGroup, false);
            c1204a = new C1204a();
            c1204a.f53932a = (LinearLayout) view.findViewById(R.id.click_head);
            c1204a.f53938g = (ImageView) view.findViewById(R.id.diver_top);
            c1204a.f53939h = (ImageView) view.findViewById(R.id.diver_buttom_px);
            c1204a.i = (ImageView) view.findViewById(R.id.diver_top_px);
            c1204a.f53933b = (GroupImageView) view.findViewById(R.id.item_head);
            c1204a.f53934c = (TextView) view.findViewById(R.id.item_group_name);
            c1204a.f53935d = (TextView) view.findViewById(R.id.item_group_num);
            c1204a.f53936e = (TextView) view.findViewById(R.id.item_introduce);
            c1204a.f53937f = (TextView) view.findViewById(R.id.isCreator);
            c1204a.j = (ImageView) view.findViewById(R.id.item_grade1);
            c1204a.k = (ImageView) view.findViewById(R.id.item_grade2);
            ImageView imageView = (ImageView) view.findViewById(R.id.item_grade3);
            c1204a.l = imageView;
            ImageView[] imageViewArr = new ImageView[4];
            c1204a.m = imageViewArr;
            imageViewArr[1] = c1204a.j;
            imageViewArr[2] = c1204a.k;
            imageViewArr[3] = imageView;
            view.setTag(c1204a);
        }
        GroupInfoData groupInfoData = this.f53931f.get(i);
        c1204a.f53933b.setTag(null);
        c1204a.f53933b.setDrawBorder(true);
        c1204a.f53933b.setPlaceHolder(1);
        if (groupInfoData != null) {
            String portrait = groupInfoData.getPortrait();
            if (!TextUtils.isEmpty(portrait)) {
                c1204a.f53933b.W(portrait, 10, false);
            } else {
                c1204a.f53933b.W("", 10, false);
            }
            c1204a.f53932a.setOnClickListener(this.f53930e);
            c1204a.f53932a.setTag(groupInfoData);
            c1204a.f53938g.setVisibility(8);
            c1204a.i.setVisibility(8);
            c1204a.f53939h.setVisibility(0);
            c1204a.f53934c.setText(groupInfoData.getName());
            TextView textView = c1204a.f53935d;
            textView.setText(groupInfoData.getMemberNum() + "/" + groupInfoData.getMaxMemberNum());
            c1204a.f53936e.setText(groupInfoData.getIntro());
            if (groupInfoData.getIsGroupManager() == 1) {
                c1204a.f53937f.setVisibility(0);
            } else {
                c1204a.f53937f.setVisibility(8);
            }
            a(c1204a.m, groupInfoData.getGrade());
        }
        this.f53930e.getBaseFragmentActivity().getLayoutMode().k(TbadkApplication.getInst().getSkinType() == 1);
        this.f53930e.getBaseFragmentActivity().getLayoutMode().j(view);
        if (groupInfoData != null && groupInfoData.isMemGroup()) {
            SkinManager.setViewTextColor(c1204a.f53934c, R.color.common_color_10009, 1);
            SkinManager.setImageResource(c1204a.j, R.drawable.icon_vip_grade_big_small_s);
            SkinManager.setImageResource(c1204a.k, R.drawable.icon_vip_grade_big_small_s);
            SkinManager.setImageResource(c1204a.l, R.drawable.icon_vip_grade_big_small_s);
        }
        return view;
    }
}
