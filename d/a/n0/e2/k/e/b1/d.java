package d.a.n0.e2.k.e.b1;

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
    public List<EmotionImageData> f53147f;

    /* renamed from: h  reason: collision with root package name */
    public d.a.n0.e2.k.e.b1.a f53149h;
    public List<String> k;

    /* renamed from: e  reason: collision with root package name */
    public Context f53146e = BdBaseApplication.getInst().getApp();

    /* renamed from: g  reason: collision with root package name */
    public Set<String> f53148g = new HashSet();
    public int j = l.g(this.f53146e, R.dimen.ds116);

    /* renamed from: i  reason: collision with root package name */
    public int f53150i = (int) (((l.k(this.f53146e) - l.g(this.f53146e, R.dimen.ds88)) - (this.j * 4)) * 0.333d);

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
            if (d.this.f53149h != null && (view instanceof EmotionView)) {
                d.this.f53149h.a((EmotionImageData) tag, ((EmotionView) view).getIsGif());
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
            if (d.this.f53148g != null) {
                for (String str : d.this.f53148g) {
                    if (!TextUtils.isEmpty(str)) {
                        d.a.m0.a0.c.k().h(str);
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
        public EmotionView f53153a;

        /* renamed from: b  reason: collision with root package name */
        public EmotionView f53154b;

        /* renamed from: c  reason: collision with root package name */
        public EmotionView f53155c;

        /* renamed from: d  reason: collision with root package name */
        public EmotionView f53156d;

        public c() {
        }

        public void a() {
            d.this.e(this.f53153a);
            d.this.e(this.f53154b);
            d.this.e(this.f53155c);
            d.this.e(this.f53156d);
        }
    }

    public d(List<EmotionImageData> list) {
        this.f53147f = list;
    }

    public final void d(EmotionView emotionView, EmotionImageData emotionImageData) {
        if (emotionView == null || emotionImageData == null) {
            return;
        }
        emotionView.setTag(emotionView.getId(), emotionImageData);
        emotionView.A0();
        emotionView.C0(emotionImageData);
        if (this.f53148g == null || TextUtils.isEmpty(emotionImageData.getThumbUrl())) {
            return;
        }
        if (ListUtils.isEmpty(this.k) || !this.k.contains(emotionImageData.getThumbUrl())) {
            Set<String> set = this.f53148g;
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
        this.f53149h = null;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        if (this.f53147f.size() % 4 == 0) {
            return this.f53147f.size() / 4;
        }
        return (this.f53147f.size() / 4) + 1;
    }

    @Override // android.widget.Adapter
    public Object getItem(int i2) {
        return this.f53147f.get(i2);
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
            cVar2.f53153a = (EmotionView) inflate.findViewById(R.id.emotion_view1);
            cVar2.f53154b = (EmotionView) inflate.findViewById(R.id.emotion_view2);
            cVar2.f53155c = (EmotionView) inflate.findViewById(R.id.emotion_view3);
            cVar2.f53156d = (EmotionView) inflate.findViewById(R.id.emotion_view4);
            cVar2.a();
            i(cVar2.f53154b, this.f53150i);
            i(cVar2.f53155c, this.f53150i);
            i(cVar2.f53156d, this.f53150i);
            inflate.setTag(cVar2);
            cVar = cVar2;
            view = inflate;
        } else {
            cVar = (c) view.getTag();
        }
        int i3 = i2 * 4;
        int i4 = i3 + 4;
        int min = Math.min(i4, this.f53147f.size() - 1);
        for (int i5 = i3; i5 < i4; i5++) {
            if (i5 <= min) {
                EmotionImageData emotionImageData = this.f53147f.get(i5);
                int i6 = i5 - i3;
                if (i6 == 0) {
                    d(cVar.f53153a, emotionImageData);
                } else if (i6 == 1) {
                    d(cVar.f53154b, emotionImageData);
                } else if (i6 == 2) {
                    d(cVar.f53155c, emotionImageData);
                } else if (i6 == 3) {
                    d(cVar.f53156d, emotionImageData);
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

    public void j(d.a.n0.e2.k.e.b1.a aVar) {
        this.f53149h = aVar;
    }
}
