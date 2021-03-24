package d.b.i0.c2.k.e.y0;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tieba.R;
import com.baidu.tieba.face.data.EmotionImageData;
import com.baidu.tieba.face.view.EmotionView;
import java.util.List;
/* loaded from: classes4.dex */
public class b extends BaseAdapter {

    /* renamed from: e  reason: collision with root package name */
    public List<EmotionImageData> f52937e;

    /* renamed from: f  reason: collision with root package name */
    public InterfaceC1158b f52938f;

    /* renamed from: g  reason: collision with root package name */
    public EmotionView.c f52939g;

    /* loaded from: classes4.dex */
    public class a implements View.OnClickListener {
        public a() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (b.this.f52938f == null || !(view instanceof EmotionView)) {
                return;
            }
            b.this.f52938f.e(((EmotionView) view).getData());
        }
    }

    /* renamed from: d.b.i0.c2.k.e.y0.b$b  reason: collision with other inner class name */
    /* loaded from: classes4.dex */
    public interface InterfaceC1158b {
        void e(EmotionImageData emotionImageData);
    }

    /* loaded from: classes4.dex */
    public static class c {

        /* renamed from: a  reason: collision with root package name */
        public EmotionView f52941a;
    }

    public void b(List<EmotionImageData> list) {
        this.f52937e = list;
    }

    public void c(EmotionView.c cVar) {
        this.f52939g = cVar;
    }

    public void d(InterfaceC1158b interfaceC1158b) {
        this.f52938f = interfaceC1158b;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        if (ListUtils.isEmpty(this.f52937e)) {
            return 0;
        }
        return this.f52937e.size();
    }

    @Override // android.widget.Adapter
    public Object getItem(int i) {
        return null;
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        return 0L;
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        View view2;
        c cVar;
        if (view == null) {
            cVar = new c();
            view2 = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.list_sug_emotion, (ViewGroup) null);
            EmotionView emotionView = (EmotionView) view2.findViewById(R.id.emotion_view);
            cVar.f52941a = emotionView;
            emotionView.A0();
            cVar.f52941a.setController(this.f52939g);
            cVar.f52941a.setOnClickListener(new a());
            view2.setTag(cVar);
        } else {
            view2 = view;
            cVar = (c) view.getTag();
        }
        List<EmotionImageData> list = this.f52937e;
        if (list != null && i >= 0 && i < list.size()) {
            cVar.f52941a.C0(this.f52937e.get(i));
        }
        return view2;
    }
}
