package com.kwad.sdk.core.imageloader.core.assist.deque;
/* loaded from: classes7.dex */
public class LIFOLinkedBlockingDeque extends LinkedBlockingDeque {
    public static final long serialVersionUID = -4114786347960826192L;

    @Override // com.kwad.sdk.core.imageloader.core.assist.deque.LinkedBlockingDeque, java.util.Queue, com.kwad.sdk.core.imageloader.core.assist.deque.BlockingDeque, com.kwad.sdk.core.imageloader.core.assist.deque.Deque, java.util.concurrent.BlockingQueue
    public boolean offer(Object obj) {
        return super.offerFirst(obj);
    }

    @Override // com.kwad.sdk.core.imageloader.core.assist.deque.LinkedBlockingDeque, java.util.AbstractQueue, java.util.Queue, com.kwad.sdk.core.imageloader.core.assist.deque.BlockingDeque, com.kwad.sdk.core.imageloader.core.assist.deque.Deque
    public Object remove() {
        return super.removeFirst();
    }
}
