package d.b.j0.d2.k.e.a1.g;

import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tieba.R;
import com.baidu.tieba.face.data.EmotionImageData;
import com.baidu.tieba.face.view.EmotionView;
import com.baidu.tieba.pb.pb.main.emotion.view.PbEmotionBar;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
/* loaded from: classes3.dex */
public class a extends BaseAdapter {

    /* renamed from: e  reason: collision with root package name */
    public List<EmotionImageData> f54426e;

    /* renamed from: f  reason: collision with root package name */
    public int f54427f;

    /* renamed from: g  reason: collision with root package name */
    public EmotionView.c f54428g;

    /* renamed from: h  reason: collision with root package name */
    public PbEmotionBar.i f54429h;
    public Set<String> i = new HashSet();

    /* renamed from: d.b.j0.d2.k.e.a1.g.a$a  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public class View$OnClickListenerC1232a implements View.OnClickListener {
        public View$OnClickListenerC1232a() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (a.this.f54429h == null || !(view instanceof EmotionView)) {
                return;
            }
            EmotionView emotionView = (EmotionView) view;
            a.this.f54429h.a(emotionView.getData(), emotionView.getIsGif());
            TiebaStatic.log("c12176");
        }
    }

    /* loaded from: classes3.dex */
    public class b implements View.OnClickListener {
        public b() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (a.this.f54429h != null) {
                ArrayList arrayList = new ArrayList();
                if (!ListUtils.isEmpty(a.this.f54426e)) {
                    for (EmotionImageData emotionImageData : a.this.f54426e) {
                        if (emotionImageData != null && !TextUtils.isEmpty(emotionImageData.getThumbUrl())) {
                            arrayList.add(emotionImageData.getThumbUrl());
                        }
                    }
                }
                a.this.f54429h.b(null, null, arrayList);
            }
        }
    }

    /* loaded from: classes3.dex */
    public class c extends BdAsyncTask<Void, Void, Boolean> {
        public c() {
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public Boolean doInBackground(Void... voidArr) {
            if (a.this.i != null) {
                for (String str : a.this.i) {
                    if (!TextUtils.isEmpty(str)) {
                        d.b.i0.a0.c.k().h(str);
                    }
                }
                return Boolean.TRUE;
            }
            return Boolean.TRUE;
        }
    }

    /* loaded from: classes3.dex */
    public static class d {

        /* renamed from: a  reason: collision with root package name */
        public EmotionView f54433a;

        /* renamed from: b  reason: collision with root package name */
        public TextView f54434b;
    }

    public void d() {
        new c().execute(new Void[0]);
    }

    public void e(List<EmotionImageData> list) {
        this.f54426e = list;
    }

    public void f(EmotionView.c cVar) {
        this.f54428g = cVar;
    }

    public void g(PbEmotionBar.i iVar) {
        this.f54429h = iVar;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        if (ListUtils.isEmpty(this.f54426e)) {
            return 0;
        }
        return this.f54426e.size() + 1;
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
        d dVar;
        if (view == null) {
            dVar = new d();
            view2 = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.list_item_pb_emotion_bar, (ViewGroup) null);
            EmotionView emotionView = (EmotionView) view2.findViewById(R.id.iv_emotion);
            dVar.f54433a = emotionView;
            emotionView.A0();
            dVar.f54433a.setController(this.f54428g);
            dVar.f54433a.setOnClickListener(new View$OnClickListenerC1232a());
            TextView textView = (TextView) view2.findViewById(R.id.tv_more);
            dVar.f54434b = textView;
            SkinManager.setViewTextColor(textView, R.color.CAM_X0109);
            dVar.f54434b.setOnClickListener(new b());
            view2.setTag(dVar);
        } else {
            view2 = view;
            dVar = (d) view.getTag();
        }
        if (i >= 0) {
            if (i < this.f54426e.size()) {
                dVar.f54433a.getLayoutParams().width = this.f54427f;
                dVar.f54433a.getLayoutParams().height = this.f54427f;
                dVar.f54433a.S();
                dVar.f54433a.setTag(R.id.iv_emotion, null);
                EmotionImageData emotionImageData = this.f54426e.get(i);
                if (emotionImageData != null) {
                    dVar.f54433a.C0(emotionImageData);
                    if (this.i != null && !TextUtils.isEmpty(emotionImageData.getThumbUrl())) {
                        Set<String> set = this.i;
                        set.add(emotionImageData.getThumbUrl() + dVar.f54433a.getLoadProcType());
                    }
                }
                dVar.f54433a.setVisibility(0);
                dVar.f54434b.setVisibility(8);
            } else if (i == this.f54426e.size()) {
                dVar.f54434b.getLayoutParams().width = this.f54427f;
                dVar.f54434b.getLayoutParams().height = this.f54427f;
                dVar.f54433a.setVisibility(8);
                dVar.f54434b.setVisibility(0);
            }
        }
        return view2;
    }

    public void h(int i) {
        if (this.f54427f != i) {
            this.f54427f = i;
            notifyDataSetChanged();
        }
    }
}
