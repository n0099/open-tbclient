package kotlin.collections.unsigned;

import kotlin.Metadata;
import kotlin.UShortArray;
import kotlin.collections.UShortIterator;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\b\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "Lkotlin/collections/UShortIterator;", "invoke"}, k = 3, mv = {1, 1, 15}, pn = "", xi = 0, xs = "")
/* loaded from: classes7.dex */
public final class UArraysKt___UArraysKt$withIndex$4 extends Lambda implements Function0<UShortIterator> {
    public final /* synthetic */ short[] $this_withIndex;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public UArraysKt___UArraysKt$withIndex$4(short[] sArr) {
        super(0);
        this.$this_withIndex = sArr;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // kotlin.jvm.functions.Function0
    public final UShortIterator invoke() {
        return UShortArray.m932iteratorimpl(this.$this_withIndex);
    }
}
