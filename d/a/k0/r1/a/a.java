package d.a.k0.r1.a;

import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tieba.R;
import com.baidu.tieba.memberCenter.bubble.BubbleChooseActivity;
import com.baidu.tieba.memberCenter.bubble.BubbleListData;
import com.baidu.tieba.memberCenter.bubble.BubbleView;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes3.dex */
public class a extends BaseAdapter {

    /* renamed from: e  reason: collision with root package name */
    public List<BubbleListData.BubbleData> f60267e = new ArrayList();

    /* renamed from: f  reason: collision with root package name */
    public TbPageContext<BubbleChooseActivity> f60268f;

    /* renamed from: g  reason: collision with root package name */
    public int f60269g;

    /* renamed from: h  reason: collision with root package name */
    public int f60270h;

    /* renamed from: i  reason: collision with root package name */
    public boolean f60271i;

    public a(TbPageContext<BubbleChooseActivity> tbPageContext) {
        this.f60268f = tbPageContext;
        this.f60269g = (int) tbPageContext.getResources().getDimension(R.dimen.ds30);
        this.f60270h = (int) this.f60268f.getResources().getDimension(R.dimen.ds30);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.widget.Adapter
    /* renamed from: a */
    public BubbleListData.BubbleData getItem(int i2) {
        List<BubbleListData.BubbleData> list = this.f60267e;
        if (list != null) {
            if (i2 >= 0 || i2 < list.size()) {
                return this.f60267e.get(i2);
            }
            return null;
        }
        return null;
    }

    public List<BubbleListData.BubbleData> b() {
        return this.f60267e;
    }

    public void c(List<BubbleListData.BubbleData> list) {
        this.f60267e.clear();
        BubbleListData.BubbleData bubbleData = new BubbleListData.BubbleData();
        bubbleData.setBcode(0);
        this.f60267e.add(bubbleData);
        this.f60267e.addAll(list);
        notifyDataSetChanged();
    }

    public void d(boolean z) {
        this.f60271i = z;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        List<BubbleListData.BubbleData> list = this.f60267e;
        if (list == null) {
            return 0;
        }
        return list.size();
    }

    @Override // android.widget.Adapter
    public long getItemId(int i2) {
        return i2;
    }

    @Override // android.widget.Adapter
    public View getView(int i2, View view, ViewGroup viewGroup) {
        BubbleView bubbleView;
        BubbleView bubbleView2;
        if (view == null) {
            bubbleView2 = new BubbleView(this.f60268f.getPageActivity());
            bubbleView = bubbleView2;
        } else {
            bubbleView = view;
            bubbleView2 = (BubbleView) view;
        }
        if (i2 == 0 || i2 == 1) {
            bubbleView2.setPadding(0, this.f60270h, 0, 0);
        }
        if (getCount() % 2 == 0) {
            if (i2 == getCount() - 1 || i2 == getCount() - 2) {
                bubbleView2.setPadding(0, bubbleView2.getPaddingTop(), 0, this.f60269g);
            }
        } else if (i2 == getCount() - 1) {
            bubbleView2.setPadding(0, bubbleView2.getPaddingTop(), 0, this.f60269g);
        }
        BubbleListData.BubbleData item = getItem(i2);
        if (item != null) {
            bubbleView2.setShowName(true);
            bubbleView2.setData(item, this.f60271i);
        }
        bubbleView2.a(this.f60268f);
        return bubbleView;
    }
}
