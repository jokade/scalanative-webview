/*
 * libwebview.c
 * Copyright (C) 2018 kastner <kastner@dagobah.local>
 *
 * Distributed under terms of the MIT license.
 */
#define WEBVIEW_IMPLEMENTATION
#include "webview.h"

typedef struct webview* WEBVIEW;

WEBVIEW webview_new(const char* title, const char* url, int width, int height, int resizable) {
  WEBVIEW view = (WEBVIEW)malloc(sizeof(struct webview));
  view->title = title;
  view->url = url;
  view->width = width;
  view->height = height;
  view->debug = 0;
  view->resizable = resizable;
  return view;
}

void webview_free(WEBVIEW view) {
  free(view);
}


