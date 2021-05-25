package d.a.n0.e2.k.e.b1;

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
    public List<EmotionImageData> f53132e;

    /* renamed from: f  reason: collision with root package name */
    public InterfaceC1259b f53133f;

    /* renamed from: g  reason: collision with root package name */
    public EmotionView.c f53134g;

    /* loaded from: classes5.dex */
    public class a implements View.OnClickListener {
        public a() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (b.this.f53133f == null || !(view instanceof EmotionView)) {
                return;
            }
            b.this.f53133f.f(((EmotionView) view).getData());
        }
    }

    /* renamed from: d.a.n0.e2.k.e.b1.b$b  reason: collision with other inner class name */
    /* loaded from: classes5.dex */
    public interface InterfaceC1259b {
        void f(EmotionImageData emotionImageData);
    }

    /* loaded from: classes5.dex */
    public static class c {

        /* renamed from: a  reason: collision with root package name */
        public EmotionView f53136a;
    }

    public void b(List<EmotionImageData> list) {
        this.f53132e = list;
    }

    public void c(EmotionView.c cVar) {
        this.f53134g = cVar;
    }

    public void d(InterfaceC1259b interfaceC1259b) {
        this.f53133f = interfaceC1259b;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        if (ListUtils.isEmpty(this.f53132e)) {
            return 0;
        }
        return this.f53132e.size();
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
            cVar.f53136a = emotionView;
            emotionView.A0();
            cVar.f53136a.setController(this.f53134g);
            cVar.f53136a.setOnClickListener(new a());
            view2.setTag(cVar);
        } else {
            view2 = view;
            cVar = (c) view.getTag();
        }
        List<EmotionImageData> list = this.f53132e;
        if (list != null && i2 >= 0 && i2 < list.size()) {
            cVar.f53136a.C0(this.f53132e.get(i2));
        }
        return view2;
    }
}
