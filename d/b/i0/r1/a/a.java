package d.b.i0.r1.a;

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
    public List<BubbleListData.BubbleData> f60959e = new ArrayList();

    /* renamed from: f  reason: collision with root package name */
    public TbPageContext<BubbleChooseActivity> f60960f;

    /* renamed from: g  reason: collision with root package name */
    public int f60961g;

    /* renamed from: h  reason: collision with root package name */
    public int f60962h;
    public boolean i;

    public a(TbPageContext<BubbleChooseActivity> tbPageContext) {
        this.f60960f = tbPageContext;
        this.f60961g = (int) tbPageContext.getResources().getDimension(R.dimen.ds30);
        this.f60962h = (int) this.f60960f.getResources().getDimension(R.dimen.ds30);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.widget.Adapter
    /* renamed from: a */
    public BubbleListData.BubbleData getItem(int i) {
        List<BubbleListData.BubbleData> list = this.f60959e;
        if (list != null) {
            if (i >= 0 || i < list.size()) {
                return this.f60959e.get(i);
            }
            return null;
        }
        return null;
    }

    public List<BubbleListData.BubbleData> b() {
        return this.f60959e;
    }

    public void c(List<BubbleListData.BubbleData> list) {
        this.f60959e.clear();
        BubbleListData.BubbleData bubbleData = new BubbleListData.BubbleData();
        bubbleData.setBcode(0);
        this.f60959e.add(bubbleData);
        this.f60959e.addAll(list);
        notifyDataSetChanged();
    }

    public void d(boolean z) {
        this.i = z;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        List<BubbleListData.BubbleData> list = this.f60959e;
        if (list == null) {
            return 0;
        }
        return list.size();
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        return i;
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        BubbleView bubbleView;
        BubbleView bubbleView2;
        if (view == null) {
            bubbleView2 = new BubbleView(this.f60960f.getPageActivity());
            bubbleView = bubbleView2;
        } else {
            bubbleView = view;
            bubbleView2 = (BubbleView) view;
        }
        if (i == 0 || i == 1) {
            bubbleView2.setPadding(0, this.f60962h, 0, 0);
        }
        if (getCount() % 2 == 0) {
            if (i == getCount() - 1 || i == getCount() - 2) {
                bubbleView2.setPadding(0, bubbleView2.getPaddingTop(), 0, this.f60961g);
            }
        } else if (i == getCount() - 1) {
            bubbleView2.setPadding(0, bubbleView2.getPaddingTop(), 0, this.f60961g);
        }
        BubbleListData.BubbleData item = getItem(i);
        if (item != null) {
            bubbleView2.setShowName(true);
            bubbleView2.setData(item, this.i);
        }
        bubbleView2.a(this.f60960f);
        return bubbleView;
    }
}
