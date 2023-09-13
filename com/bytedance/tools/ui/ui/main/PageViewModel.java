package com.bytedance.tools.ui.ui.main;

import androidx.arch.core.util.Function;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Transformations;
import androidx.lifecycle.ViewModel;
/* loaded from: classes9.dex */
public class PageViewModel extends ViewModel {
    public MutableLiveData<Integer> a;

    /* loaded from: classes9.dex */
    public class a implements Function<Integer, String> {
        public a(PageViewModel pageViewModel) {
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // androidx.arch.core.util.Function
        /* renamed from: a */
        public String apply(Integer num) {
            return "Hello world from section: " + num;
        }
    }

    public PageViewModel() {
        MutableLiveData<Integer> mutableLiveData = new MutableLiveData<>();
        this.a = mutableLiveData;
        Transformations.map(mutableLiveData, new a(this));
    }
}
