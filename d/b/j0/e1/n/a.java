package d.b.j0.e1.n;

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
    public PersonalGroupFragment f55874e;

    /* renamed from: f  reason: collision with root package name */
    public List<GroupInfoData> f55875f = new ArrayList();

    /* renamed from: d.b.j0.e1.n.a$a  reason: collision with other inner class name */
    /* loaded from: classes4.dex */
    public static class C1291a {

        /* renamed from: a  reason: collision with root package name */
        public LinearLayout f55876a;

        /* renamed from: b  reason: collision with root package name */
        public GroupImageView f55877b;

        /* renamed from: c  reason: collision with root package name */
        public TextView f55878c;

        /* renamed from: d  reason: collision with root package name */
        public TextView f55879d;

        /* renamed from: e  reason: collision with root package name */
        public TextView f55880e;

        /* renamed from: f  reason: collision with root package name */
        public TextView f55881f;

        /* renamed from: g  reason: collision with root package name */
        public ImageView f55882g;

        /* renamed from: h  reason: collision with root package name */
        public ImageView f55883h;
        public ImageView i;
        public ImageView j;
        public ImageView k;
        public ImageView l;
        public ImageView[] m;
    }

    public a(PersonalGroupFragment personalGroupFragment) {
        this.f55874e = personalGroupFragment;
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
        if (itemId < 0 || itemId >= this.f55875f.size()) {
            return null;
        }
        return this.f55875f.get(itemId);
    }

    public void c(List<GroupInfoData> list) {
        this.f55875f = list;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        return this.f55875f.size();
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        return i;
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        C1291a c1291a;
        if (view != null && view.getTag() != null && (view.getTag() instanceof C1291a)) {
            c1291a = (C1291a) view.getTag();
        } else {
            view = LayoutInflater.from(this.f55874e.getActivity()).inflate(R.layout.tab_my_group_item, viewGroup, false);
            c1291a = new C1291a();
            c1291a.f55876a = (LinearLayout) view.findViewById(R.id.click_head);
            c1291a.f55882g = (ImageView) view.findViewById(R.id.diver_top);
            c1291a.f55883h = (ImageView) view.findViewById(R.id.diver_buttom_px);
            c1291a.i = (ImageView) view.findViewById(R.id.diver_top_px);
            c1291a.f55877b = (GroupImageView) view.findViewById(R.id.item_head);
            c1291a.f55878c = (TextView) view.findViewById(R.id.item_group_name);
            c1291a.f55879d = (TextView) view.findViewById(R.id.item_group_num);
            c1291a.f55880e = (TextView) view.findViewById(R.id.item_introduce);
            c1291a.f55881f = (TextView) view.findViewById(R.id.isCreator);
            c1291a.j = (ImageView) view.findViewById(R.id.item_grade1);
            c1291a.k = (ImageView) view.findViewById(R.id.item_grade2);
            ImageView imageView = (ImageView) view.findViewById(R.id.item_grade3);
            c1291a.l = imageView;
            ImageView[] imageViewArr = new ImageView[4];
            c1291a.m = imageViewArr;
            imageViewArr[1] = c1291a.j;
            imageViewArr[2] = c1291a.k;
            imageViewArr[3] = imageView;
            view.setTag(c1291a);
        }
        GroupInfoData groupInfoData = this.f55875f.get(i);
        c1291a.f55877b.setTag(null);
        c1291a.f55877b.setDrawBorder(true);
        c1291a.f55877b.setPlaceHolder(1);
        if (groupInfoData != null) {
            String portrait = groupInfoData.getPortrait();
            if (!TextUtils.isEmpty(portrait)) {
                c1291a.f55877b.W(portrait, 10, false);
            } else {
                c1291a.f55877b.W("", 10, false);
            }
            c1291a.f55876a.setOnClickListener(this.f55874e);
            c1291a.f55876a.setTag(groupInfoData);
            c1291a.f55882g.setVisibility(8);
            c1291a.i.setVisibility(8);
            c1291a.f55883h.setVisibility(0);
            c1291a.f55878c.setText(groupInfoData.getName());
            TextView textView = c1291a.f55879d;
            textView.setText(groupInfoData.getMemberNum() + "/" + groupInfoData.getMaxMemberNum());
            c1291a.f55880e.setText(groupInfoData.getIntro());
            if (groupInfoData.getIsGroupManager() == 1) {
                c1291a.f55881f.setVisibility(0);
            } else {
                c1291a.f55881f.setVisibility(8);
            }
            a(c1291a.m, groupInfoData.getGrade());
        }
        this.f55874e.getBaseFragmentActivity().getLayoutMode().k(TbadkApplication.getInst().getSkinType() == 1);
        this.f55874e.getBaseFragmentActivity().getLayoutMode().j(view);
        if (groupInfoData != null && groupInfoData.isMemGroup()) {
            SkinManager.setViewTextColor(c1291a.f55878c, R.color.common_color_10009, 1);
            SkinManager.setImageResource(c1291a.j, R.drawable.icon_vip_grade_big_small_s);
            SkinManager.setImageResource(c1291a.k, R.drawable.icon_vip_grade_big_small_s);
            SkinManager.setImageResource(c1291a.l, R.drawable.icon_vip_grade_big_small_s);
        }
        return view;
    }
}
