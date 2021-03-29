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
/* loaded from: classes3.dex */
public class a extends BaseAdapter {

    /* renamed from: e  reason: collision with root package name */
    public PersonalGroupFragment f53931e;

    /* renamed from: f  reason: collision with root package name */
    public List<GroupInfoData> f53932f = new ArrayList();

    /* renamed from: d.b.i0.d1.n.a$a  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public static class C1205a {

        /* renamed from: a  reason: collision with root package name */
        public LinearLayout f53933a;

        /* renamed from: b  reason: collision with root package name */
        public GroupImageView f53934b;

        /* renamed from: c  reason: collision with root package name */
        public TextView f53935c;

        /* renamed from: d  reason: collision with root package name */
        public TextView f53936d;

        /* renamed from: e  reason: collision with root package name */
        public TextView f53937e;

        /* renamed from: f  reason: collision with root package name */
        public TextView f53938f;

        /* renamed from: g  reason: collision with root package name */
        public ImageView f53939g;

        /* renamed from: h  reason: collision with root package name */
        public ImageView f53940h;
        public ImageView i;
        public ImageView j;
        public ImageView k;
        public ImageView l;
        public ImageView[] m;
    }

    public a(PersonalGroupFragment personalGroupFragment) {
        this.f53931e = personalGroupFragment;
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
        if (itemId < 0 || itemId >= this.f53932f.size()) {
            return null;
        }
        return this.f53932f.get(itemId);
    }

    public void c(List<GroupInfoData> list) {
        this.f53932f = list;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        return this.f53932f.size();
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        return i;
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        C1205a c1205a;
        if (view != null && view.getTag() != null && (view.getTag() instanceof C1205a)) {
            c1205a = (C1205a) view.getTag();
        } else {
            view = LayoutInflater.from(this.f53931e.getActivity()).inflate(R.layout.tab_my_group_item, viewGroup, false);
            c1205a = new C1205a();
            c1205a.f53933a = (LinearLayout) view.findViewById(R.id.click_head);
            c1205a.f53939g = (ImageView) view.findViewById(R.id.diver_top);
            c1205a.f53940h = (ImageView) view.findViewById(R.id.diver_buttom_px);
            c1205a.i = (ImageView) view.findViewById(R.id.diver_top_px);
            c1205a.f53934b = (GroupImageView) view.findViewById(R.id.item_head);
            c1205a.f53935c = (TextView) view.findViewById(R.id.item_group_name);
            c1205a.f53936d = (TextView) view.findViewById(R.id.item_group_num);
            c1205a.f53937e = (TextView) view.findViewById(R.id.item_introduce);
            c1205a.f53938f = (TextView) view.findViewById(R.id.isCreator);
            c1205a.j = (ImageView) view.findViewById(R.id.item_grade1);
            c1205a.k = (ImageView) view.findViewById(R.id.item_grade2);
            ImageView imageView = (ImageView) view.findViewById(R.id.item_grade3);
            c1205a.l = imageView;
            ImageView[] imageViewArr = new ImageView[4];
            c1205a.m = imageViewArr;
            imageViewArr[1] = c1205a.j;
            imageViewArr[2] = c1205a.k;
            imageViewArr[3] = imageView;
            view.setTag(c1205a);
        }
        GroupInfoData groupInfoData = this.f53932f.get(i);
        c1205a.f53934b.setTag(null);
        c1205a.f53934b.setDrawBorder(true);
        c1205a.f53934b.setPlaceHolder(1);
        if (groupInfoData != null) {
            String portrait = groupInfoData.getPortrait();
            if (!TextUtils.isEmpty(portrait)) {
                c1205a.f53934b.W(portrait, 10, false);
            } else {
                c1205a.f53934b.W("", 10, false);
            }
            c1205a.f53933a.setOnClickListener(this.f53931e);
            c1205a.f53933a.setTag(groupInfoData);
            c1205a.f53939g.setVisibility(8);
            c1205a.i.setVisibility(8);
            c1205a.f53940h.setVisibility(0);
            c1205a.f53935c.setText(groupInfoData.getName());
            TextView textView = c1205a.f53936d;
            textView.setText(groupInfoData.getMemberNum() + "/" + groupInfoData.getMaxMemberNum());
            c1205a.f53937e.setText(groupInfoData.getIntro());
            if (groupInfoData.getIsGroupManager() == 1) {
                c1205a.f53938f.setVisibility(0);
            } else {
                c1205a.f53938f.setVisibility(8);
            }
            a(c1205a.m, groupInfoData.getGrade());
        }
        this.f53931e.getBaseFragmentActivity().getLayoutMode().k(TbadkApplication.getInst().getSkinType() == 1);
        this.f53931e.getBaseFragmentActivity().getLayoutMode().j(view);
        if (groupInfoData != null && groupInfoData.isMemGroup()) {
            SkinManager.setViewTextColor(c1205a.f53935c, R.color.common_color_10009, 1);
            SkinManager.setImageResource(c1205a.j, R.drawable.icon_vip_grade_big_small_s);
            SkinManager.setImageResource(c1205a.k, R.drawable.icon_vip_grade_big_small_s);
            SkinManager.setImageResource(c1205a.l, R.drawable.icon_vip_grade_big_small_s);
        }
        return view;
    }
}
