package d.a.o0.e2.k.e.b1;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tieba.R;
import com.baidu.tieba.face.data.EmotionImageData;
import com.baidu.tieba.face.view.EmotionView;
import java.util.List;
/* loaded from: classes5.dex */
public class b extends BaseAdapter {

    /* renamed from: e  reason: collision with root package name */
    public List<EmotionImageData> f56946e;

    /* renamed from: f  reason: collision with root package name */
    public InterfaceC1319b f56947f;

    /* renamed from: g  reason: collision with root package name */
    public EmotionView.c f56948g;

    /* loaded from: classes5.dex */
    public class a implements View.OnClickListener {
        public a() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (b.this.f56947f == null || !(view instanceof EmotionView)) {
                return;
            }
            b.this.f56947f.f(((EmotionView) view).getData());
        }
    }

    /* renamed from: d.a.o0.e2.k.e.b1.b$b  reason: collision with other inner class name */
    /* loaded from: classes5.dex */
    public interface InterfaceC1319b {
        void f(EmotionImageData emotionImageData);
    }

    /* loaded from: classes5.dex */
    public static class c {

        /* renamed from: a  reason: collision with root package name */
        public EmotionView f56950a;
    }

    public void b(List<EmotionImageData> list) {
        this.f56946e = list;
    }

    public void c(EmotionView.c cVar) {
        this.f56948g = cVar;
    }

    public void d(InterfaceC1319b interfaceC1319b) {
        this.f56947f = interfaceC1319b;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        if (ListUtils.isEmpty(this.f56946e)) {
            return 0;
        }
        return this.f56946e.size();
    }

    @Override // android.widget.Adapter
    public Object getItem(int i2) {
        return null;
    }

    @Override // android.widget.Adapter
    public long getItemId(int i2) {
        return 0L;
    }

    @Override // android.widget.Adapter
    public View getView(int i2, View view, ViewGroup viewGroup) {
        View view2;
        c cVar;
        if (view == null) {
            cVar = new c();
            view2 = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.list_sug_emotion, (ViewGroup) null);
            EmotionView emotionView = (EmotionView) view2.findViewById(R.id.emotion_view);
            cVar.f56950a = emotionView;
            emotionView.A0();
            cVar.f56950a.setController(this.f56948g);
            cVar.f56950a.setOnClickListener(new a());
            view2.setTag(cVar);
        } else {
            view2 = view;
            cVar = (c) view.getTag();
        }
        List<EmotionImageData> list = this.f56946e;
        if (list != null && i2 >= 0 && i2 < list.size()) {
            cVar.f56950a.C0(this.f56946e.get(i2));
        }
        return view2;
    }
}
