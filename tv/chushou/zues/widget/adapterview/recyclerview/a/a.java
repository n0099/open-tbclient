package tv.chushou.zues.widget.adapterview.recyclerview.a;

import android.content.res.ColorStateList;
import android.support.annotation.ColorInt;
import android.support.annotation.DrawableRes;
import android.support.annotation.LayoutRes;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.util.SparseArray;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import java.util.ArrayList;
import java.util.List;
import tv.chushou.zues.widget.adapterview.d;
import tv.chushou.zues.widget.adapterview.e;
import tv.chushou.zues.widget.fresco.FrescoThumbnailView;
/* loaded from: classes5.dex */
public abstract class a<T> extends RecyclerView.Adapter<View$OnLongClickListenerC0940a> {
    private List<T> data;
    private int nxF;
    private d okQ;
    private e okR;

    public abstract void a(View$OnLongClickListenerC0940a view$OnLongClickListenerC0940a, T t);

    public a(@LayoutRes int i, d dVar) {
        this(null, i, dVar);
    }

    public a(List<T> list, @LayoutRes int i, d dVar) {
        if (list == null) {
            this.data = new ArrayList();
        } else {
            this.data = list;
        }
        this.nxF = i;
        this.okQ = dVar;
    }

    public a(List<T> list, @LayoutRes int i, d dVar, e eVar) {
        if (list == null) {
            this.data = new ArrayList();
        } else {
            this.data = list;
        }
        this.nxF = i;
        this.okQ = dVar;
        this.okR = eVar;
    }

    public void fL(List<T> list) {
        this.data.clear();
        if (list != null) {
            this.data.addAll(list);
            notifyDataSetChanged();
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.support.v7.widget.RecyclerView.Adapter
    /* renamed from: K */
    public View$OnLongClickListenerC0940a onCreateViewHolder(ViewGroup viewGroup, int i) {
        return new View$OnLongClickListenerC0940a(LayoutInflater.from(viewGroup.getContext()).inflate(Kt(i), viewGroup, false), this.okQ, this.okR);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public int Kt(int i) {
        return this.nxF;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.support.v7.widget.RecyclerView.Adapter
    /* renamed from: a */
    public void onBindViewHolder(View$OnLongClickListenerC0940a view$OnLongClickListenerC0940a, int i) {
        a(view$OnLongClickListenerC0940a, (View$OnLongClickListenerC0940a) this.data.get(i), i);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.support.v7.widget.RecyclerView.Adapter
    /* renamed from: a */
    public void onBindViewHolder(@NonNull View$OnLongClickListenerC0940a view$OnLongClickListenerC0940a, int i, @NonNull List<Object> list) {
        onBindViewHolder(view$OnLongClickListenerC0940a, i);
    }

    public T getItem(int i) {
        if (this.data == null || i >= this.data.size()) {
            return null;
        }
        return this.data.get(i);
    }

    public void a(View$OnLongClickListenerC0940a view$OnLongClickListenerC0940a, T t, int i) {
        a(view$OnLongClickListenerC0940a, (View$OnLongClickListenerC0940a) t);
    }

    @Override // android.support.v7.widget.RecyclerView.Adapter
    public int getItemCount() {
        if (this.data == null) {
            return 0;
        }
        return this.data.size();
    }

    /* renamed from: tv.chushou.zues.widget.adapterview.recyclerview.a.a$a  reason: collision with other inner class name */
    /* loaded from: classes5.dex */
    public static class View$OnLongClickListenerC0940a extends RecyclerView.ViewHolder implements View.OnLongClickListener {
        private final View.OnClickListener mOnClickListener;
        private SparseArray<View> nxP;
        private d okQ;
        private e okR;

        public View$OnLongClickListenerC0940a(View view, d dVar, e eVar) {
            super(view);
            this.mOnClickListener = new tv.chushou.zues.a() { // from class: tv.chushou.zues.widget.adapterview.recyclerview.a.a.a.1
                @Override // tv.chushou.zues.a
                public void ds(View view2) {
                    if (View$OnLongClickListenerC0940a.this.okQ != null) {
                        View$OnLongClickListenerC0940a.this.okQ.B(view2, View$OnLongClickListenerC0940a.this.getLayoutPosition());
                    }
                }
            };
            this.okQ = dVar;
            this.okR = eVar;
            this.nxP = new SparseArray<>();
            view.setOnClickListener(this.mOnClickListener);
            view.setOnLongClickListener(this);
        }

        public <V extends View> V or(int i) {
            V v = (V) this.nxP.get(i);
            if (v == null) {
                V v2 = (V) this.itemView.findViewById(i);
                this.nxP.put(i, v2);
                return v2;
            }
            return v;
        }

        public View$OnLongClickListenerC0940a a(int i, CharSequence charSequence) {
            TextView textView = (TextView) or(i);
            if (textView != null) {
                textView.setText(charSequence);
            }
            return this;
        }

        public View$OnLongClickListenerC0940a ef(int i, @ColorInt int i2) {
            TextView textView = (TextView) or(i);
            if (textView != null) {
                textView.setTextColor(i2);
            }
            return this;
        }

        public View$OnLongClickListenerC0940a a(int i, ColorStateList colorStateList) {
            TextView textView = (TextView) or(i);
            if (textView != null) {
                textView.setTextColor(colorStateList);
            }
            return this;
        }

        public View$OnLongClickListenerC0940a eg(int i, @DrawableRes int i2) {
            ImageView imageView = (ImageView) or(i);
            if (imageView != null) {
                imageView.setImageResource(i2);
            }
            return this;
        }

        public View$OnLongClickListenerC0940a a(int i, String str, int i2, int i3, int i4) {
            FrescoThumbnailView frescoThumbnailView = (FrescoThumbnailView) or(i);
            if (frescoThumbnailView != null) {
                frescoThumbnailView.i(str, i2, i3, i4);
            }
            return this;
        }

        public View$OnLongClickListenerC0940a a(int i, String str, int i2, int i3, int i4, int i5, boolean z, boolean z2) {
            FrescoThumbnailView frescoThumbnailView = (FrescoThumbnailView) or(i);
            if (frescoThumbnailView != null) {
                frescoThumbnailView.setGray(z);
                frescoThumbnailView.setAnim(z2);
                frescoThumbnailView.a(str, i2, i3, i4, i5);
            }
            return this;
        }

        public View$OnLongClickListenerC0940a a(boolean z, int... iArr) {
            for (int i : iArr) {
                View or = or(i);
                if (or != null) {
                    or.setVisibility(z ? 0 : 8);
                }
            }
            return this;
        }

        public View$OnLongClickListenerC0940a t(int... iArr) {
            for (int i : iArr) {
                View or = or(i);
                if (or != null) {
                    or.setOnClickListener(this.mOnClickListener);
                }
            }
            return this;
        }

        @Override // android.view.View.OnLongClickListener
        public boolean onLongClick(View view) {
            if (this.okR != null) {
                this.okR.C(view, getLayoutPosition());
                return false;
            }
            return false;
        }
    }
}
