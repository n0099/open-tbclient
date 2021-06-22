package d.a.o0.e2.k.e.b1;

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
import d.a.c.e.p.l;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
/* loaded from: classes5.dex */
public class d extends BaseAdapter {

    /* renamed from: f  reason: collision with root package name */
    public List<EmotionImageData> f56961f;

    /* renamed from: h  reason: collision with root package name */
    public d.a.o0.e2.k.e.b1.a f56963h;
    public List<String> k;

    /* renamed from: e  reason: collision with root package name */
    public Context f56960e = BdBaseApplication.getInst().getApp();

    /* renamed from: g  reason: collision with root package name */
    public Set<String> f56962g = new HashSet();
    public int j = l.g(this.f56960e, R.dimen.ds116);

    /* renamed from: i  reason: collision with root package name */
    public int f56964i = (int) (((l.k(this.f56960e) - l.g(this.f56960e, R.dimen.ds88)) - (this.j * 4)) * 0.333d);

    /* loaded from: classes5.dex */
    public class a implements View.OnClickListener {
        public a() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Object tag = view.getTag(view.getId());
            if (tag == null || !(tag instanceof EmotionImageData)) {
                return;
            }
            if (d.this.f56963h != null && (view instanceof EmotionView)) {
                d.this.f56963h.a((EmotionImageData) tag, ((EmotionView) view).getIsGif());
            }
            TiebaStatic.log("c12180");
        }
    }

    /* loaded from: classes5.dex */
    public class b extends BdAsyncTask<Void, Void, Boolean> {
        public b() {
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public Boolean doInBackground(Void... voidArr) {
            if (d.this.f56962g != null) {
                for (String str : d.this.f56962g) {
                    if (!TextUtils.isEmpty(str)) {
                        d.a.n0.a0.c.k().h(str);
                    }
                }
                return Boolean.TRUE;
            }
            return Boolean.TRUE;
        }
    }

    /* loaded from: classes5.dex */
    public class c {

        /* renamed from: a  reason: collision with root package name */
        public EmotionView f56967a;

        /* renamed from: b  reason: collision with root package name */
        public EmotionView f56968b;

        /* renamed from: c  reason: collision with root package name */
        public EmotionView f56969c;

        /* renamed from: d  reason: collision with root package name */
        public EmotionView f56970d;

        public c() {
        }

        public void a() {
            d.this.e(this.f56967a);
            d.this.e(this.f56968b);
            d.this.e(this.f56969c);
            d.this.e(this.f56970d);
        }
    }

    public d(List<EmotionImageData> list) {
        this.f56961f = list;
    }

    public final void d(EmotionView emotionView, EmotionImageData emotionImageData) {
        if (emotionView == null || emotionImageData == null) {
            return;
        }
        emotionView.setTag(emotionView.getId(), emotionImageData);
        emotionView.A0();
        emotionView.C0(emotionImageData);
        if (this.f56962g == null || TextUtils.isEmpty(emotionImageData.getThumbUrl())) {
            return;
        }
        if (ListUtils.isEmpty(this.k) || !this.k.contains(emotionImageData.getThumbUrl())) {
            Set<String> set = this.f56962g;
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
        this.f56963h = null;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        if (this.f56961f.size() % 4 == 0) {
            return this.f56961f.size() / 4;
        }
        return (this.f56961f.size() / 4) + 1;
    }

    @Override // android.widget.Adapter
    public Object getItem(int i2) {
        return this.f56961f.get(i2);
    }

    @Override // android.widget.Adapter
    public long getItemId(int i2) {
        return 0L;
    }

    @Override // android.widget.Adapter
    public View getView(int i2, View view, ViewGroup viewGroup) {
        c cVar;
        if (view == null) {
            c cVar2 = new c();
            View inflate = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.list_search_emotion_item, (ViewGroup) null);
            cVar2.f56967a = (EmotionView) inflate.findViewById(R.id.emotion_view1);
            cVar2.f56968b = (EmotionView) inflate.findViewById(R.id.emotion_view2);
            cVar2.f56969c = (EmotionView) inflate.findViewById(R.id.emotion_view3);
            cVar2.f56970d = (EmotionView) inflate.findViewById(R.id.emotion_view4);
            cVar2.a();
            i(cVar2.f56968b, this.f56964i);
            i(cVar2.f56969c, this.f56964i);
            i(cVar2.f56970d, this.f56964i);
            inflate.setTag(cVar2);
            cVar = cVar2;
            view = inflate;
        } else {
            cVar = (c) view.getTag();
        }
        int i3 = i2 * 4;
        int i4 = i3 + 4;
        int min = Math.min(i4, this.f56961f.size() - 1);
        for (int i5 = i3; i5 < i4; i5++) {
            if (i5 <= min) {
                EmotionImageData emotionImageData = this.f56961f.get(i5);
                int i6 = i5 - i3;
                if (i6 == 0) {
                    d(cVar.f56967a, emotionImageData);
                } else if (i6 == 1) {
                    d(cVar.f56968b, emotionImageData);
                } else if (i6 == 2) {
                    d(cVar.f56969c, emotionImageData);
                } else if (i6 == 3) {
                    d(cVar.f56970d, emotionImageData);
                }
            }
        }
        return view;
    }

    public void h(List<String> list) {
        this.k = list;
    }

    public final void i(View view, int i2) {
        if (view == null || view.getLayoutParams() == null) {
            return;
        }
        ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) view.getLayoutParams();
        marginLayoutParams.leftMargin = i2;
        view.setLayoutParams(marginLayoutParams);
    }

    public void j(d.a.o0.e2.k.e.b1.a aVar) {
        this.f56963h = aVar;
    }
}
