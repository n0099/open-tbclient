package d.a.o0.z1.g;

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
import d.a.c.e.p.l;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
/* loaded from: classes5.dex */
public class h extends BaseAdapter {

    /* renamed from: f  reason: collision with root package name */
    public List<EmotionImageData> f67560f;

    /* renamed from: i  reason: collision with root package name */
    public f f67563i;
    public int l;
    public final Runnable m = new b();

    /* renamed from: e  reason: collision with root package name */
    public Context f67559e = BdBaseApplication.getInst().getApp();

    /* renamed from: g  reason: collision with root package name */
    public Set<String> f67561g = new HashSet();

    /* renamed from: h  reason: collision with root package name */
    public LinkedHashMap<String, EmotionImageData> f67562h = new LinkedHashMap<>();
    public int k = l.g(this.f67559e, R.dimen.ds116);
    public int j = (int) (((l.k(this.f67559e) - l.g(this.f67559e, R.dimen.ds60)) - (this.k * 4)) * 0.333d);

    /* loaded from: classes5.dex */
    public class a implements View.OnClickListener {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ PickEmotionView f67564e;

        public a(PickEmotionView pickEmotionView) {
            this.f67564e = pickEmotionView;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Object tag = view.getTag(view.getId());
            if (tag == null || !(tag instanceof EmotionImageData)) {
                return;
            }
            EmotionImageData emotionImageData = (EmotionImageData) tag;
            if (h.this.f67562h.containsKey(emotionImageData.getPicUrl())) {
                h.this.f67562h.remove(emotionImageData.getPicUrl());
                this.f67564e.setChoosed(false);
                if (h.this.f67563i != null) {
                    h.this.f67563i.onUnChoose();
                }
            } else if (h.this.f67563i != null) {
                if (h.this.f67563i.canChooseMore()) {
                    h.this.f67562h.put(emotionImageData.getPicUrl(), emotionImageData);
                    this.f67564e.setChoosed(true);
                    h.this.f67563i.onChoose();
                    return;
                }
                BdToast.c(h.this.f67559e, h.this.f67559e.getText(R.string.face_group_add_pic_max)).q();
            }
        }
    }

    /* loaded from: classes5.dex */
    public class b implements Runnable {
        public b() {
        }

        @Override // java.lang.Runnable
        public void run() {
            if (h.this.f67561g == null) {
                return;
            }
            HashSet hashSet = new HashSet();
            Iterator it = h.this.f67562h.entrySet().iterator();
            while (it.hasNext()) {
                hashSet.add(((EmotionImageData) ((Map.Entry) it.next()).getValue()).getThumbUrl() + h.this.l);
            }
            for (String str : h.this.f67561g) {
                if (!TextUtils.isEmpty(str) && !hashSet.contains(str)) {
                    d.a.n0.a0.c.k().h(str);
                }
            }
        }
    }

    /* loaded from: classes5.dex */
    public class c {

        /* renamed from: a  reason: collision with root package name */
        public PickEmotionView f67567a;

        /* renamed from: b  reason: collision with root package name */
        public PickEmotionView f67568b;

        /* renamed from: c  reason: collision with root package name */
        public PickEmotionView f67569c;

        /* renamed from: d  reason: collision with root package name */
        public PickEmotionView f67570d;

        public c() {
        }

        public void a() {
            h.this.j(this.f67567a);
            h.this.j(this.f67568b);
            h.this.j(this.f67569c);
            h.this.j(this.f67570d);
        }
    }

    public h(List<EmotionImageData> list, int i2) {
        this.f67560f = list;
        this.l = i2;
    }

    public void g(Map<String, EmotionImageData> map) {
        this.f67562h.putAll(map);
    }

    @Override // android.widget.Adapter
    public int getCount() {
        List<EmotionImageData> list = this.f67560f;
        if (list != null) {
            if (list.size() % 4 == 0) {
                return this.f67560f.size() / 4;
            }
            return (this.f67560f.size() / 4) + 1;
        }
        return 0;
    }

    @Override // android.widget.Adapter
    public Object getItem(int i2) {
        List<EmotionImageData> list = this.f67560f;
        if (list == null || i2 > list.size() - 1) {
            return null;
        }
        return this.f67560f.get(i2);
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
            View inflate = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.list_item_emotion, (ViewGroup) null);
            cVar2.f67567a = (PickEmotionView) inflate.findViewById(R.id.emotion_view1);
            cVar2.f67568b = (PickEmotionView) inflate.findViewById(R.id.emotion_view2);
            cVar2.f67569c = (PickEmotionView) inflate.findViewById(R.id.emotion_view3);
            cVar2.f67570d = (PickEmotionView) inflate.findViewById(R.id.emotion_view4);
            cVar2.a();
            n(cVar2.f67568b, this.j);
            n(cVar2.f67569c, this.j);
            n(cVar2.f67570d, this.j);
            inflate.setTag(cVar2);
            cVar = cVar2;
            view = inflate;
        } else {
            cVar = (c) view.getTag();
        }
        int i3 = i2 * 4;
        int i4 = i3 + 4;
        int min = Math.min(i4, this.f67560f.size() - 1);
        int i5 = i3;
        while (i5 < i4) {
            EmotionImageData emotionImageData = i5 <= min ? this.f67560f.get(i5) : null;
            int i6 = i5 - i3;
            if (i6 == 0) {
                h(cVar.f67567a, emotionImageData);
            } else if (i6 == 1) {
                h(cVar.f67568b, emotionImageData);
            } else if (i6 == 2) {
                h(cVar.f67569c, emotionImageData);
            } else if (i6 == 3) {
                h(cVar.f67570d, emotionImageData);
            }
            i5++;
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
        if (this.f67561g == null || TextUtils.isEmpty(emotionImageData.getThumbUrl())) {
            return;
        }
        Set<String> set = this.f67561g;
        set.add(emotionImageData.getThumbUrl() + pickEmotionView.getLoadType());
    }

    public LinkedHashMap<String, EmotionImageData> i() {
        return this.f67562h;
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
        this.f67563i = fVar;
    }

    public final void m(PickEmotionView pickEmotionView, EmotionImageData emotionImageData) {
        if (this.f67562h.containsKey(emotionImageData.getPicUrl())) {
            pickEmotionView.setChoosed(true);
        } else {
            pickEmotionView.setChoosed(false);
        }
    }

    public final void n(View view, int i2) {
        if (view == null || view.getLayoutParams() == null) {
            return;
        }
        ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) view.getLayoutParams();
        marginLayoutParams.leftMargin = i2;
        view.setLayoutParams(marginLayoutParams);
    }
}
