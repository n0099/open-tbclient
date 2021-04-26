package d.a.j0.d2.k.e.a1;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tieba.R;
import com.baidu.tieba.face.data.EmotionImageData;
import com.baidu.tieba.face.view.EmotionView;
import java.util.List;
/* loaded from: classes3.dex */
public class b extends BaseAdapter {

    /* renamed from: e  reason: collision with root package name */
    public List<EmotionImageData> f52176e;

    /* renamed from: f  reason: collision with root package name */
    public InterfaceC1168b f52177f;

    /* renamed from: g  reason: collision with root package name */
    public EmotionView.c f52178g;

    /* loaded from: classes3.dex */
    public class a implements View.OnClickListener {
        public a() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (b.this.f52177f == null || !(view instanceof EmotionView)) {
                return;
            }
            b.this.f52177f.f(((EmotionView) view).getData());
        }
    }

    /* renamed from: d.a.j0.d2.k.e.a1.b$b  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public interface InterfaceC1168b {
        void f(EmotionImageData emotionImageData);
    }

    /* loaded from: classes3.dex */
    public static class c {

        /* renamed from: a  reason: collision with root package name */
        public EmotionView f52180a;
    }

    public void b(List<EmotionImageData> list) {
        this.f52176e = list;
    }

    public void c(EmotionView.c cVar) {
        this.f52178g = cVar;
    }

    public void d(InterfaceC1168b interfaceC1168b) {
        this.f52177f = interfaceC1168b;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        if (ListUtils.isEmpty(this.f52176e)) {
            return 0;
        }
        return this.f52176e.size();
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
            cVar.f52180a = emotionView;
            emotionView.A0();
            cVar.f52180a.setController(this.f52178g);
            cVar.f52180a.setOnClickListener(new a());
            view2.setTag(cVar);
        } else {
            view2 = view;
            cVar = (c) view.getTag();
        }
        List<EmotionImageData> list = this.f52176e;
        if (list != null && i2 >= 0 && i2 < list.size()) {
            cVar.f52180a.C0(this.f52176e.get(i2));
        }
        return view2;
    }
}
