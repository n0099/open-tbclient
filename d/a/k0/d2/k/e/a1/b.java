package d.a.k0.d2.k.e.a1;

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
    public List<EmotionImageData> f52875e;

    /* renamed from: f  reason: collision with root package name */
    public InterfaceC1240b f52876f;

    /* renamed from: g  reason: collision with root package name */
    public EmotionView.c f52877g;

    /* loaded from: classes5.dex */
    public class a implements View.OnClickListener {
        public a() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (b.this.f52876f == null || !(view instanceof EmotionView)) {
                return;
            }
            b.this.f52876f.f(((EmotionView) view).getData());
        }
    }

    /* renamed from: d.a.k0.d2.k.e.a1.b$b  reason: collision with other inner class name */
    /* loaded from: classes5.dex */
    public interface InterfaceC1240b {
        void f(EmotionImageData emotionImageData);
    }

    /* loaded from: classes5.dex */
    public static class c {

        /* renamed from: a  reason: collision with root package name */
        public EmotionView f52879a;
    }

    public void b(List<EmotionImageData> list) {
        this.f52875e = list;
    }

    public void c(EmotionView.c cVar) {
        this.f52877g = cVar;
    }

    public void d(InterfaceC1240b interfaceC1240b) {
        this.f52876f = interfaceC1240b;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        if (ListUtils.isEmpty(this.f52875e)) {
            return 0;
        }
        return this.f52875e.size();
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
            cVar.f52879a = emotionView;
            emotionView.A0();
            cVar.f52879a.setController(this.f52877g);
            cVar.f52879a.setOnClickListener(new a());
            view2.setTag(cVar);
        } else {
            view2 = view;
            cVar = (c) view.getTag();
        }
        List<EmotionImageData> list = this.f52875e;
        if (list != null && i2 >= 0 && i2 < list.size()) {
            cVar.f52879a.C0(this.f52875e.get(i2));
        }
        return view2;
    }
}
