package d.b.i0.x1.g;

import android.content.Context;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import com.baidu.adp.base.BdBaseApplication;
import com.baidu.tbadk.core.dialog.BdToast;
import com.baidu.tieba.R;
import com.baidu.tieba.face.data.EmotionImageData;
import com.baidu.tieba.newfaceshop.facemake.PickEmotionView;
import d.b.b.e.p.l;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
/* loaded from: classes3.dex */
public class h extends BaseAdapter {

    /* renamed from: f  reason: collision with root package name */
    public List<EmotionImageData> f62444f;
    public f i;
    public int l;
    public final Runnable m = new b();

    /* renamed from: e  reason: collision with root package name */
    public Context f62443e = BdBaseApplication.getInst().getApp();

    /* renamed from: g  reason: collision with root package name */
    public Set<String> f62445g = new HashSet();

    /* renamed from: h  reason: collision with root package name */
    public LinkedHashMap<String, EmotionImageData> f62446h = new LinkedHashMap<>();
    public int k = l.g(this.f62443e, R.dimen.ds116);
    public int j = (int) (((l.k(this.f62443e) - l.g(this.f62443e, R.dimen.ds60)) - (this.k * 4)) * 0.333d);

    /* loaded from: classes3.dex */
    public class a implements View.OnClickListener {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ PickEmotionView f62447e;

        public a(PickEmotionView pickEmotionView) {
            this.f62447e = pickEmotionView;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Object tag = view.getTag(view.getId());
            if (tag == null || !(tag instanceof EmotionImageData)) {
                return;
            }
            EmotionImageData emotionImageData = (EmotionImageData) tag;
            if (h.this.f62446h.containsKey(emotionImageData.getPicUrl())) {
                h.this.f62446h.remove(emotionImageData.getPicUrl());
                this.f62447e.setChoosed(false);
                if (h.this.i != null) {
                    h.this.i.onUnChoose();
                }
            } else if (h.this.i != null) {
                if (h.this.i.canChooseMore()) {
                    h.this.f62446h.put(emotionImageData.getPicUrl(), emotionImageData);
                    this.f62447e.setChoosed(true);
                    h.this.i.onChoose();
                    return;
                }
                BdToast.c(h.this.f62443e, h.this.f62443e.getText(R.string.face_group_add_pic_max)).q();
            }
        }
    }

    /* loaded from: classes3.dex */
    public class b implements Runnable {
        public b() {
        }

        @Override // java.lang.Runnable
        public void run() {
            if (h.this.f62445g == null) {
                return;
            }
            HashSet hashSet = new HashSet();
            Iterator it = h.this.f62446h.entrySet().iterator();
            while (it.hasNext()) {
                hashSet.add(((EmotionImageData) ((Map.Entry) it.next()).getValue()).getThumbUrl() + h.this.l);
            }
            for (String str : h.this.f62445g) {
                if (!TextUtils.isEmpty(str) && !hashSet.contains(str)) {
                    d.b.h0.a0.c.j().g(str);
                }
            }
        }
    }

    /* loaded from: classes3.dex */
    public class c {

        /* renamed from: a  reason: collision with root package name */
        public PickEmotionView f62450a;

        /* renamed from: b  reason: collision with root package name */
        public PickEmotionView f62451b;

        /* renamed from: c  reason: collision with root package name */
        public PickEmotionView f62452c;

        /* renamed from: d  reason: collision with root package name */
        public PickEmotionView f62453d;

        public c() {
        }

        public void a() {
            h.this.j(this.f62450a);
            h.this.j(this.f62451b);
            h.this.j(this.f62452c);
            h.this.j(this.f62453d);
        }
    }

    public h(List<EmotionImageData> list, int i) {
        this.f62444f = list;
        this.l = i;
    }

    public void g(Map<String, EmotionImageData> map) {
        this.f62446h.putAll(map);
    }

    @Override // android.widget.Adapter
    public int getCount() {
        List<EmotionImageData> list = this.f62444f;
        if (list != null) {
            if (list.size() % 4 == 0) {
                return this.f62444f.size() / 4;
            }
            return (this.f62444f.size() / 4) + 1;
        }
        return 0;
    }

    @Override // android.widget.Adapter
    public Object getItem(int i) {
        List<EmotionImageData> list = this.f62444f;
        if (list == null || i > list.size() - 1) {
            return null;
        }
        return this.f62444f.get(i);
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
            View inflate = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.list_item_emotion, (ViewGroup) null);
            cVar2.f62450a = (PickEmotionView) inflate.findViewById(R.id.emotion_view1);
            cVar2.f62451b = (PickEmotionView) inflate.findViewById(R.id.emotion_view2);
            cVar2.f62452c = (PickEmotionView) inflate.findViewById(R.id.emotion_view3);
            cVar2.f62453d = (PickEmotionView) inflate.findViewById(R.id.emotion_view4);
            cVar2.a();
            n(cVar2.f62451b, this.j);
            n(cVar2.f62452c, this.j);
            n(cVar2.f62453d, this.j);
            inflate.setTag(cVar2);
            cVar = cVar2;
            view = inflate;
        } else {
            cVar = (c) view.getTag();
        }
        int i2 = i * 4;
        int i3 = i2 + 4;
        int min = Math.min(i3, this.f62444f.size() - 1);
        int i4 = i2;
        while (i4 < i3) {
            EmotionImageData emotionImageData = i4 <= min ? this.f62444f.get(i4) : null;
            int i5 = i4 - i2;
            if (i5 == 0) {
                h(cVar.f62450a, emotionImageData);
            } else if (i5 == 1) {
                h(cVar.f62451b, emotionImageData);
            } else if (i5 == 2) {
                h(cVar.f62452c, emotionImageData);
            } else if (i5 == 3) {
                h(cVar.f62453d, emotionImageData);
            }
            i4++;
        }
        return view;
    }

    public final void h(PickEmotionView pickEmotionView, EmotionImageData emotionImageData) {
        if (pickEmotionView == null) {
            return;
        }
        if (emotionImageData == null) {
            pickEmotionView.setVisibility(4);
            return;
        }
        pickEmotionView.getEmotionView().setTag(pickEmotionView.getEmotionView().getId(), emotionImageData);
        pickEmotionView.setData(emotionImageData, this.l);
        m(pickEmotionView, emotionImageData);
        if (this.f62445g == null || TextUtils.isEmpty(emotionImageData.getThumbUrl())) {
            return;
        }
        Set<String> set = this.f62445g;
        set.add(emotionImageData.getThumbUrl() + pickEmotionView.getLoadType());
    }

    public LinkedHashMap<String, EmotionImageData> i() {
        return this.f62446h;
    }

    public final void j(PickEmotionView pickEmotionView) {
        if (pickEmotionView == null) {
            return;
        }
        pickEmotionView.getEmotionView().setOnClickListener(new a(pickEmotionView));
    }

    public void k() {
        new Thread(this.m).start();
    }

    public void l(f fVar) {
        this.i = fVar;
    }

    public final void m(PickEmotionView pickEmotionView, EmotionImageData emotionImageData) {
        if (this.f62446h.containsKey(emotionImageData.getPicUrl())) {
            pickEmotionView.setChoosed(true);
        } else {
            pickEmotionView.setChoosed(false);
        }
    }

    public final void n(View view, int i) {
        if (view == null || view.getLayoutParams() == null) {
            return;
        }
        ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) view.getLayoutParams();
        marginLayoutParams.leftMargin = i;
        view.setLayoutParams(marginLayoutParams);
    }
}
