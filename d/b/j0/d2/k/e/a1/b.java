package d.b.j0.d2.k.e.a1;

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
    public List<EmotionImageData> f54386e;

    /* renamed from: f  reason: collision with root package name */
    public InterfaceC1229b f54387f;

    /* renamed from: g  reason: collision with root package name */
    public EmotionView.c f54388g;

    /* loaded from: classes3.dex */
    public class a implements View.OnClickListener {
        public a() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (b.this.f54387f == null || !(view instanceof EmotionView)) {
                return;
            }
            b.this.f54387f.e(((EmotionView) view).getData());
        }
    }

    /* renamed from: d.b.j0.d2.k.e.a1.b$b  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public interface InterfaceC1229b {
        void e(EmotionImageData emotionImageData);
    }

    /* loaded from: classes3.dex */
    public static class c {

        /* renamed from: a  reason: collision with root package name */
        public EmotionView f54390a;
    }

    public void b(List<EmotionImageData> list) {
        this.f54386e = list;
    }

    public void c(EmotionView.c cVar) {
        this.f54388g = cVar;
    }

    public void d(InterfaceC1229b interfaceC1229b) {
        this.f54387f = interfaceC1229b;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        if (ListUtils.isEmpty(this.f54386e)) {
            return 0;
        }
        return this.f54386e.size();
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
            cVar.f54390a = emotionView;
            emotionView.A0();
            cVar.f54390a.setController(this.f54388g);
            cVar.f54390a.setOnClickListener(new a());
            view2.setTag(cVar);
        } else {
            view2 = view;
            cVar = (c) view.getTag();
        }
        List<EmotionImageData> list = this.f54386e;
        if (list != null && i >= 0 && i < list.size()) {
            cVar.f54390a.C0(this.f54386e.get(i));
        }
        return view2;
    }
}
