package d.a.k0.y1.g;

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
/* loaded from: classes4.dex */
public class h extends BaseAdapter {

    /* renamed from: f  reason: collision with root package name */
    public List<EmotionImageData> f63553f;

    /* renamed from: i  reason: collision with root package name */
    public f f63556i;
    public int l;
    public final Runnable m = new b();

    /* renamed from: e  reason: collision with root package name */
    public Context f63552e = BdBaseApplication.getInst().getApp();

    /* renamed from: g  reason: collision with root package name */
    public Set<String> f63554g = new HashSet();

    /* renamed from: h  reason: collision with root package name */
    public LinkedHashMap<String, EmotionImageData> f63555h = new LinkedHashMap<>();
    public int k = l.g(this.f63552e, R.dimen.ds116);
    public int j = (int) (((l.k(this.f63552e) - l.g(this.f63552e, R.dimen.ds60)) - (this.k * 4)) * 0.333d);

    /* loaded from: classes4.dex */
    public class a implements View.OnClickListener {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ PickEmotionView f63557e;

        public a(PickEmotionView pickEmotionView) {
            this.f63557e = pickEmotionView;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Object tag = view.getTag(view.getId());
            if (tag == null || !(tag instanceof EmotionImageData)) {
                return;
            }
            EmotionImageData emotionImageData = (EmotionImageData) tag;
            if (h.this.f63555h.containsKey(emotionImageData.getPicUrl())) {
                h.this.f63555h.remove(emotionImageData.getPicUrl());
                this.f63557e.setChoosed(false);
                if (h.this.f63556i != null) {
                    h.this.f63556i.onUnChoose();
                }
            } else if (h.this.f63556i != null) {
                if (h.this.f63556i.canChooseMore()) {
                    h.this.f63555h.put(emotionImageData.getPicUrl(), emotionImageData);
                    this.f63557e.setChoosed(true);
                    h.this.f63556i.onChoose();
                    return;
                }
                BdToast.c(h.this.f63552e, h.this.f63552e.getText(R.string.face_group_add_pic_max)).q();
            }
        }
    }

    /* loaded from: classes4.dex */
    public class b implements Runnable {
        public b() {
        }

        @Override // java.lang.Runnable
        public void run() {
            if (h.this.f63554g == null) {
                return;
            }
            HashSet hashSet = new HashSet();
            Iterator it = h.this.f63555h.entrySet().iterator();
            while (it.hasNext()) {
                hashSet.add(((EmotionImageData) ((Map.Entry) it.next()).getValue()).getThumbUrl() + h.this.l);
            }
            for (String str : h.this.f63554g) {
                if (!TextUtils.isEmpty(str) && !hashSet.contains(str)) {
                    d.a.j0.a0.c.k().h(str);
                }
            }
        }
    }

    /* loaded from: classes4.dex */
    public class c {

        /* renamed from: a  reason: collision with root package name */
        public PickEmotionView f63560a;

        /* renamed from: b  reason: collision with root package name */
        public PickEmotionView f63561b;

        /* renamed from: c  reason: collision with root package name */
        public PickEmotionView f63562c;

        /* renamed from: d  reason: collision with root package name */
        public PickEmotionView f63563d;

        public c() {
        }

        public void a() {
            h.this.j(this.f63560a);
            h.this.j(this.f63561b);
            h.this.j(this.f63562c);
            h.this.j(this.f63563d);
        }
    }

    public h(List<EmotionImageData> list, int i2) {
        this.f63553f = list;
        this.l = i2;
    }

    public void g(Map<String, EmotionImageData> map) {
        this.f63555h.putAll(map);
    }

    @Override // android.widget.Adapter
    public int getCount() {
        List<EmotionImageData> list = this.f63553f;
        if (list != null) {
            if (list.size() % 4 == 0) {
                return this.f63553f.size() / 4;
            }
            return (this.f63553f.size() / 4) + 1;
        }
        return 0;
    }

    @Override // android.widget.Adapter
    public Object getItem(int i2) {
        List<EmotionImageData> list = this.f63553f;
        if (list == null || i2 > list.size() - 1) {
            return null;
        }
        return this.f63553f.get(i2);
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
            cVar2.f63560a = (PickEmotionView) inflate.findViewById(R.id.emotion_view1);
            cVar2.f63561b = (PickEmotionView) inflate.findViewById(R.id.emotion_view2);
            cVar2.f63562c = (PickEmotionView) inflate.findViewById(R.id.emotion_view3);
            cVar2.f63563d = (PickEmotionView) inflate.findViewById(R.id.emotion_view4);
            cVar2.a();
            n(cVar2.f63561b, this.j);
            n(cVar2.f63562c, this.j);
            n(cVar2.f63563d, this.j);
            inflate.setTag(cVar2);
            cVar = cVar2;
            view = inflate;
        } else {
            cVar = (c) view.getTag();
        }
        int i3 = i2 * 4;
        int i4 = i3 + 4;
        int min = Math.min(i4, this.f63553f.size() - 1);
        int i5 = i3;
        while (i5 < i4) {
            EmotionImageData emotionImageData = i5 <= min ? this.f63553f.get(i5) : null;
            int i6 = i5 - i3;
            if (i6 == 0) {
                h(cVar.f63560a, emotionImageData);
            } else if (i6 == 1) {
                h(cVar.f63561b, emotionImageData);
            } else if (i6 == 2) {
                h(cVar.f63562c, emotionImageData);
            } else if (i6 == 3) {
                h(cVar.f63563d, emotionImageData);
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
        if (this.f63554g == null || TextUtils.isEmpty(emotionImageData.getThumbUrl())) {
            return;
        }
        Set<String> set = this.f63554g;
        set.add(emotionImageData.getThumbUrl() + pickEmotionView.getLoadType());
    }

    public LinkedHashMap<String, EmotionImageData> i() {
        return this.f63555h;
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
        this.f63556i = fVar;
    }

    public final void m(PickEmotionView pickEmotionView, EmotionImageData emotionImageData) {
        if (this.f63555h.containsKey(emotionImageData.getPicUrl())) {
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
