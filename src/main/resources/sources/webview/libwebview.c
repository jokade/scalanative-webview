/*
 * libwebview.c
 * Copyright (C) 2018 kastner <kastner@dagobah.local>
 *
 * Distributed under terms of the MIT license.
 */
#define WEBVIEW_IMPLEMENTATION
#include "webview.h"

typedef struct webview* WEBVIEW;

WEBVIEW webview_new(const char* title, const char* url, int width, int height, int resizable, int debug, webview_external_invoke_cb_t callback) {
  WEBVIEW view = (WEBVIEW)malloc(sizeof(struct webview));
  view->title = title;
  view->url = url;
  view->width = width;
  view->height = height;
  view->debug = debug;
  view->resizable = resizable;
  view->external_invoke_cb = callback;
  return view;
}

void webview_free(WEBVIEW view) {
  free(view);
}


