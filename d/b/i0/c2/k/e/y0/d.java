package d.b.i0.c2.k.e.y0;

import android.content.Context;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import com.baidu.adp.base.BdBaseApplication;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tieba.R;
import com.baidu.tieba.face.data.EmotionImageData;
import com.baidu.tieba.face.view.EmotionView;
import d.b.b.e.p.l;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
/* loaded from: classes4.dex */
public class d extends BaseAdapter {

    /* renamed from: f  reason: collision with root package name */
    public List<EmotionImageData> f52951f;

    /* renamed from: h  reason: collision with root package name */
    public d.b.i0.c2.k.e.y0.a f52953h;
    public int i;
    public List<String> k;

    /* renamed from: e  reason: collision with root package name */
    public Context f52950e = BdBaseApplication.getInst().getApp();

    /* renamed from: g  reason: collision with root package name */
    public Set<String> f52952g = new HashSet();
    public int j = l.g(this.f52950e, R.dimen.ds116);

    /* loaded from: classes4.dex */
    public class a implements View.OnClickListener {
        public a() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Object tag = view.getTag(view.getId());
            if (tag == null || !(tag instanceof EmotionImageData)) {
                return;
            }
            if (d.this.f52953h != null && (view instanceof EmotionView)) {
                d.this.f52953h.a((EmotionImageData) tag, ((EmotionView) view).getIsGif());
            }
            TiebaStatic.log("c12180");
        }
    }

    /* loaded from: classes4.dex */
    public class b extends BdAsyncTask<Void, Void, Boolean> {
        public b() {
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public Boolean doInBackground(Void... voidArr) {
            if (d.this.f52952g != null) {
                for (String str : d.this.f52952g) {
                    if (!TextUtils.isEmpty(str)) {
                        d.b.h0.a0.c.j().g(str);
                    }
                }
                return Boolean.TRUE;
            }
            return Boolean.TRUE;
        }
    }

    /* loaded from: classes4.dex */
    public class c {

        /* renamed from: a  reason: collision with root package name */
        public EmotionView f52956a;

        /* renamed from: b  reason: collision with root package name */
        public EmotionView f52957b;

        /* renamed from: c  reason: collision with root package name */
        public EmotionView f52958c;

        /* renamed from: d  reason: collision with root package name */
        public EmotionView f52959d;

        public c() {
        }

        public void a() {
            d.this.e(this.f52956a);
            d.this.e(this.f52957b);
            d.this.e(this.f52958c);
            d.this.e(this.f52959d);
        }
    }

    public d(List<EmotionImageData> list) {
        this.f52951f = list;
        double k = (l.k(this.f52950e) - l.g(this.f52950e, R.dimen.ds88)) - (this.j * 4);
        Double.isNaN(k);
        this.i = (int) (k * 0.333d);
    }

    public final void d(EmotionView emotionView, EmotionImageData emotionImageData) {
        if (emotionView == null || emotionImageData == null) {
            return;
        }
        emotionView.setTag(emotionView.getId(), emotionImageData);
        emotionView.A0();
        emotionView.C0(emotionImageData);
        if (this.f52952g == null || TextUtils.isEmpty(emotionImageData.getThumbUrl())) {
            return;
        }
        if (ListUtils.isEmpty(this.k) || !this.k.contains(emotionImageData.getThumbUrl())) {
            Set<String> set = this.f52952g;
            set.add(emotionImageData.getThumbUrl() + emotionView.getLoadProcType());
        }
    }

    public final void e(EmotionView emotionView) {
        if (emotionView == null) {
            return;
        }
        emotionView.setOnClickListener(new a());
    }

    public void f() {
        new b().execute(new Void[0]);
    }

    public void g() {
        this.f52953h = null;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        if (this.f52951f.size() % 4 == 0) {
            return this.f52951f.size() / 4;
        }
        return (this.f52951f.size() / 4) + 1;
    }

    @Override // android.widget.Adapter
    public Object getItem(int i) {
        return this.f52951f.get(i);
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        return 0L;
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        c cVar;
        if (view == null) {
            c cVar2 = new c();
            View inflate = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.list_search_emotion_item, (ViewGroup) null);
            cVar2.f52956a = (EmotionView) inflate.findViewById(R.id.emotion_view1);
            cVar2.f52957b = (EmotionView) inflate.findViewById(R.id.emotion_view2);
            cVar2.f52958c = (EmotionView) inflate.findViewById(R.id.emotion_view3);
            cVar2.f52959d = (EmotionView) inflate.findViewById(R.id.emotion_view4);
            cVar2.a();
            i(cVar2.f52957b, this.i);
            i(cVar2.f52958c, this.i);
            i(cVar2.f52959d, this.i);
            inflate.setTag(cVar2);
            cVar = cVar2;
            view = inflate;
        } else {
            cVar = (c) view.getTag();
        }
        int i2 = i * 4;
        int i3 = i2 + 4;
        int min = Math.min(i3, this.f52951f.size() - 1);
        for (int i4 = i2; i4 < i3; i4++) {
            if (i4 <= min) {
                EmotionImageData emotionImageData = this.f52951f.get(i4);
                int i5 = i4 - i2;
                if (i5 == 0) {
                    d(cVar.f52956a, emotionImageData);
                } else if (i5 == 1) {
                    d(cVar.f52957b, emotionImageData);
                } else if (i5 == 2) {
                    d(cVar.f52958c, emotionImageData);
                } else if (i5 == 3) {
                    d(cVar.f52959d, emotionImageData);
                }
            }
        }
        return view;
    }

    public void h(List<String> list) {
        this.k = list;
    }

    public final void i(View view, int i) {
        if (view == null || view.getLayoutParams() == null) {
            return;
        }
        ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) view.getLayoutParams();
        marginLayoutParams.leftMargin = i;
        view.setLayoutParams(marginLayoutParams);
    }

    public void j(d.b.i0.c2.k.e.y0.a aVar) {
        this.f52953h = aVar;
    }
}
