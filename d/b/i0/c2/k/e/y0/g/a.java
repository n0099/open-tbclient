package d.b.i0.c2.k.e.y0.g;

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
/* loaded from: classes4.dex */
public class a extends BaseAdapter {

    /* renamed from: e  reason: collision with root package name */
    public List<EmotionImageData> f52978e;

    /* renamed from: f  reason: collision with root package name */
    public int f52979f;

    /* renamed from: g  reason: collision with root package name */
    public EmotionView.c f52980g;

    /* renamed from: h  reason: collision with root package name */
    public PbEmotionBar.i f52981h;
    public Set<String> i = new HashSet();

    /* renamed from: d.b.i0.c2.k.e.y0.g.a$a  reason: collision with other inner class name */
    /* loaded from: classes4.dex */
    public class View$OnClickListenerC1162a implements View.OnClickListener {
        public View$OnClickListenerC1162a() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (a.this.f52981h == null || !(view instanceof EmotionView)) {
                return;
            }
            EmotionView emotionView = (EmotionView) view;
            a.this.f52981h.a(emotionView.getData(), emotionView.getIsGif());
            TiebaStatic.log("c12176");
        }
    }

    /* loaded from: classes4.dex */
    public class b implements View.OnClickListener {
        public b() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (a.this.f52981h != null) {
                ArrayList arrayList = new ArrayList();
                if (!ListUtils.isEmpty(a.this.f52978e)) {
                    for (EmotionImageData emotionImageData : a.this.f52978e) {
                        if (emotionImageData != null && !TextUtils.isEmpty(emotionImageData.getThumbUrl())) {
                            arrayList.add(emotionImageData.getThumbUrl());
                        }
                    }
                }
                a.this.f52981h.b(null, null, arrayList);
            }
        }
    }

    /* loaded from: classes4.dex */
    public class c extends BdAsyncTask<Void, Void, Boolean> {
        public c() {
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public Boolean doInBackground(Void... voidArr) {
            if (a.this.i != null) {
                for (String str : a.this.i) {
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
    public static class d {

        /* renamed from: a  reason: collision with root package name */
        public EmotionView f52985a;

        /* renamed from: b  reason: collision with root package name */
        public TextView f52986b;
    }

    public void d() {
        new c().execute(new Void[0]);
    }

    public void e(List<EmotionImageData> list) {
        this.f52978e = list;
    }

    public void f(EmotionView.c cVar) {
        this.f52980g = cVar;
    }

    public void g(PbEmotionBar.i iVar) {
        this.f52981h = iVar;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        if (ListUtils.isEmpty(this.f52978e)) {
            return 0;
        }
        return this.f52978e.size() + 1;
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
            dVar.f52985a = emotionView;
            emotionView.A0();
            dVar.f52985a.setController(this.f52980g);
            dVar.f52985a.setOnClickListener(new View$OnClickListenerC1162a());
            TextView textView = (TextView) view2.findViewById(R.id.tv_more);
            dVar.f52986b = textView;
            SkinManager.setViewTextColor(textView, R.color.CAM_X0109);
            dVar.f52986b.setOnClickListener(new b());
            view2.setTag(dVar);
        } else {
            view2 = view;
            dVar = (d) view.getTag();
        }
        if (i >= 0) {
            if (i < this.f52978e.size()) {
                dVar.f52985a.getLayoutParams().width = this.f52979f;
                dVar.f52985a.getLayoutParams().height = this.f52979f;
                dVar.f52985a.S();
                dVar.f52985a.setTag(R.id.iv_emotion, null);
                EmotionImageData emotionImageData = this.f52978e.get(i);
                if (emotionImageData != null) {
                    dVar.f52985a.C0(emotionImageData);
                    if (this.i != null && !TextUtils.isEmpty(emotionImageData.getThumbUrl())) {
                        Set<String> set = this.i;
                        set.add(emotionImageData.getThumbUrl() + dVar.f52985a.getLoadProcType());
                    }
                }
                dVar.f52985a.setVisibility(0);
                dVar.f52986b.setVisibility(8);
            } else if (i == this.f52978e.size()) {
                dVar.f52986b.getLayoutParams().width = this.f52979f;
                dVar.f52986b.getLayoutParams().height = this.f52979f;
                dVar.f52985a.setVisibility(8);
                dVar.f52986b.setVisibility(0);
            }
        }
        return view2;
    }

    public void h(int i) {
        if (this.f52979f != i) {
            this.f52979f = i;
            notifyDataSetChanged();
        }
    }
}
